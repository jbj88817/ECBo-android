package us.bojie.latte.net;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import us.bojie.latte.net.callback.IError;
import us.bojie.latte.net.callback.IFailure;
import us.bojie.latte.net.callback.IRequest;
import us.bojie.latte.net.callback.ISuccess;

/**
 * Created by bojiejiang on 1/26/18.
 */

public class RestClientBuilder {

    private String mUrl;
    private static Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IFailure mIFailure;
    private IError mIError;
    private RequestBody mBody;

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

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody);
    }
}
