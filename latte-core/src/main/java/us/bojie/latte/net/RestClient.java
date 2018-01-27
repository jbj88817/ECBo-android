package us.bojie.latte.net;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import us.bojie.latte.net.callback.IError;
import us.bojie.latte.net.callback.IFailure;
import us.bojie.latte.net.callback.IRequest;
import us.bojie.latte.net.callback.ISuccess;

/**
 * Created by bojiejiang on 1/26/18.
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IFailure failure, IError error,
                      RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }
}
