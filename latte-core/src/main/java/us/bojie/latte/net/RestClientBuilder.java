package us.bojie.latte.net;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import us.bojie.latte.net.callback.IError;
import us.bojie.latte.net.callback.IFailure;
import us.bojie.latte.net.callback.IRequest;
import us.bojie.latte.net.callback.ISuccess;
import us.bojie.latte.ui.LatteLoader;
import us.bojie.latte.ui.LoaderStyle;

/**
 * Created by bojiejiang on 1/26/18.
 */

public class RestClientBuilder {

    private String mUrl = null;
    private static Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder file(File file) {
        mFile = file;
        return this;
    }

    public final RestClientBuilder file(String filePath) {
        mFile = new File(filePath);
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        mExtension = extension;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        mContext = context;
        mLoaderStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        mContext = context;
        mLoaderStyle = LatteLoader.DEFAULT_LOADER;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mDownloadDir, mExtension, mName, mIRequest, mISuccess,
                mIFailure, mIError, mBody, mFile, mContext, mLoaderStyle);
    }
}
