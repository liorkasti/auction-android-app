package com.example.user.art_auction;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

public class MultipartRequest extends StringRequest {

    MultipartEntityBuilder entity = MultipartEntityBuilder.create();
    HttpEntity httpentity;
    private static final String FILE_PART_NAME = "file";

    private final Response.Listener<String> mListener;
    private final File mFilePart;
    //private final Map<String, String> mStringPart;

    public MultipartRequest(int method ,String url, File f,
                            Response.Listener<String> listener,
                            Response.ErrorListener errorListener) throws AuthFailureError {
        super(method, url,listener, errorListener);

        mListener = listener;
        mFilePart = f;
        //this.mStringPart = mStringPart;
        entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        buildMultipartEntity();
    }



    private void buildMultipartEntity() throws AuthFailureError {
        entity.addPart(FILE_PART_NAME, new FileBody(mFilePart));
        Map<String, String> params = getParams();
        /*for (Map.Entry<String, String> entry : params.entrySet()) {
            entity.addTextBody(entry.getKey(), entry.getValue(),  ContentType.TEXT_PLAIN);
        }*/
    }

    @Override
    public String getBodyContentType() {
        return httpentity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            httpentity = entity.build();
            httpentity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        return Response.success("Uploaded", getCacheEntry());
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }
}