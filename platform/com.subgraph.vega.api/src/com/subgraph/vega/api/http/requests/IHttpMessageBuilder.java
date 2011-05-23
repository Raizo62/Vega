package com.subgraph.vega.api.http.requests;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpParams;

public interface IHttpMessageBuilder {
	/**
	 * Clear contents of the message, reverting it to its initial state.
	 */
	void clear();

	/**
	 * Set message parameters. A copy of the parameters is not made.
	 *
	 * @param params Message parameters.
	 */
	void setParams(HttpParams params);

	/**
	 * Get message parameters.
	 * 
	 * @return Message parameters.
	 */
	HttpParams getParams();

	void setProtocolVersion(ProtocolVersion protocolVersion);
	ProtocolVersion getProtocolVersion();
	
	void setHeaders(Header[] headers);
	IHttpHeaderBuilder addHeader(String name, String value);
	IHttpHeaderBuilder setHeader(String name, String value);
	void removeHeader(IHttpHeaderBuilder header);
	void removeHeaders(String name);
	void clearHeaders();
	void swapHeader(int idx1, int idx2);
	int getHeaderIdxOf(IHttpHeaderBuilder next);
	int getHeaderCnt();
	IHttpHeaderBuilder getHeader(int idx);
	IHttpHeaderBuilder[] getHeaders();

	void setEntity(HttpEntity entity);
	HttpEntity getEntity();
}
