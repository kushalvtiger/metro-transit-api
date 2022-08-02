package com.target.interview.metro.transit.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Provides Metro Transit API Keys and Endpoints. Ref: https://svc.metrotransit.org/swagger/index.html
 * 
 * @author Kushal Venkategowda
 */
public class MetroTransitUtil
{
    public static final String SCHEME = "https://";

    public static final String HOST = "svc.metrotransit.org";

    public static final String NEX_TRIP_PATH = "/nexTripv2";

    public static final String AGENCIES_ENDPOINT = "/agencies";

    public static final String ROUTES_ENDPOINT = "/routes";

    public static final String DIRECTIONS_ENDPOINT = "/directions";

    public static final String STOPS_ENDPOINT = "/stops";

    public static final String VEHICLES_ENDPOINT = "/vehicles";

    /**
     * 
     * @param <T>
     * @param endPoint
     * @param classOf
     * @param gsonBuilder
     * 
     * @return
     */
    public static <T> List<T> getResultsList(final String endPoint, final Class<T[]> classOf, final GsonBuilder gsonBuilder)
    {
        try
        {
            final HttpURLConnection httpConnection = (HttpURLConnection) getURL(endPoint).openConnection();
            setupGetConnection(httpConnection);
            if (HttpURLConnection.HTTP_OK != httpConnection.getResponseCode())
            {
                // LOG/TRACE
            }
            try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream())))
            {
                final StringBuffer jsonBuffer = new StringBuffer();
                String readLine = bufferedReader.readLine();
                while (readLine != null)
                {
                    jsonBuffer.append(readLine);
                    readLine = bufferedReader.readLine();
                }
                final Gson gsonParser = gsonBuilder == null ? new Gson() : gsonBuilder.create();
                return Arrays.asList(gsonParser.fromJson(jsonBuffer.toString(), classOf));
            }
        }
        catch (final IOException e)
        {
            // LOG/TRACE
        }
        return null;
    }

    /**
     * 
     * @param endPoint
     * @return
     */
    private static URL getURL(final String endPoint)
    {
        try
        {
            return new URL(new StringBuilder(SCHEME).append(HOST).append(NEX_TRIP_PATH).append(endPoint).toString());
        }
        catch (final MalformedURLException e)
        {
            // LOG/TRACE
        }
        return null;
    }

    /**
     * 
     * @param httpConnection
     * @throws ProtocolException
     */
    private static void setupGetConnection(final HttpURLConnection httpConnection) throws ProtocolException
    {
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpConnection.setRequestProperty("accept", "application/json");
    }
}
