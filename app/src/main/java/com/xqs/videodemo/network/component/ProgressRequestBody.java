package com.xqs.videodemo.network.component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;


public class ProgressRequestBody extends RequestBody {
    private static final String TAG = "ProgressRequestBody";
    private String mRequestJsonString;
    private UploadCallbacks mListener;

    public interface UploadCallbacks {
        void onProgressUpdate(int percentage);
    }

    public ProgressRequestBody(final String json, final UploadCallbacks listener) {
        mRequestJsonString = json;
        mListener = listener;
    }

    @Override
    public MediaType contentType() {
        return MediaType.parse("application/json");
    }

    @Override
    public long contentLength() throws IOException {
        return mRequestJsonString.getBytes().length;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        byte[] buffer = new byte[2048];
        InputStream is = new ByteArrayInputStream(mRequestJsonString.getBytes(Charset.forName("UTF-8")));
        long uploaded = 0;
        long contentLength = contentLength();
        try {
            int read;
            while ((read = is.read(buffer)) != -1) {
                if (null != mListener) {
                    mListener.onProgressUpdate((int) (100 * uploaded / contentLength));
                }
                uploaded += read;
                sink.write(buffer, 0, read);
            }
        } finally {
            is.close();
        }
    }
}