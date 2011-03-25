package com.subgraph.vega.api.scanner;

import org.apache.http.client.methods.HttpUriRequest;

import com.subgraph.vega.api.crawler.ICrawlerResponseProcessor;
import com.subgraph.vega.api.http.requests.IHttpResponse;
import com.subgraph.vega.api.http.requests.IPageFingerprint;

public interface IModuleContext {
	int getCurrentIndex();
	IPathState getPathState();
	int incrementResponseCount();
	
	void addRequestResponse(HttpUriRequest request, IHttpResponse response);
	void addRequestResponse(int index, HttpUriRequest request, IHttpResponse response);
	HttpUriRequest getSavedRequest(int index);
	IHttpResponse getSavedResponse(int index);
	IPageFingerprint getSavedFingerprint(int index);
	boolean isFingerprintMatch(int idx1, int idx2);
	boolean isFingerprintMatch(int idx, IPageFingerprint fp);
	void setModuleFailed();
	boolean hasModuleFailed();
	void submitRequest(HttpUriRequest request, ICrawlerResponseProcessor callback, int index);
	void submitRequest(HttpUriRequest request, ICrawlerResponseProcessor callback);
	void submitRequest(ICrawlerResponseProcessor callback, int flag);
	void submitAlteredRequest(ICrawlerResponseProcessor callback, String value);
	void submitAlteredRequest(ICrawlerResponseProcessor callback, String value, int flag);
	void submitAlteredRequest(ICrawlerResponseProcessor callback, String value, boolean append, int flag);
	void submitAlteredParameterNameRequest(ICrawlerResponseProcessor callback, String name, int flag);
	void submitMultipleAlteredRequests(ICrawlerResponseProcessor callback, String[] injectables);
	void submitMultipleAlteredRequests(ICrawlerResponseProcessor callback, String[] injectables, boolean append);
	
	void error(HttpUriRequest request, IHttpResponse response, String message);
	void debug(String msg);
	void publishAlert(String type, String key, String message, HttpUriRequest request, IHttpResponse response, Object ...properties);
	void publishAlert(String type, String message, HttpUriRequest request, IHttpResponse response, Object ...properties);
	
	void responseChecks(int idx);
	void responseChecks(HttpUriRequest request, IHttpResponse response);
	void contentChecks(HttpUriRequest request, IHttpResponse response);
	void pivotChecks(HttpUriRequest request, IHttpResponse response);

	void analyzePage(HttpUriRequest request, IHttpResponse response);
}
