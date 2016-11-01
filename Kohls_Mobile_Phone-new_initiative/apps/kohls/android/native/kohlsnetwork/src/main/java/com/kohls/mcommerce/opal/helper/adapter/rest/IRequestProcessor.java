package com.kohls.mcommerce.opal.helper.adapter.rest;

import com.kohls.mcommerce.opal.helper.adapter.AdapterProcedure;
import com.worklight.wlclient.api.WLResponseListener;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public interface IRequestProcessor {

	public boolean process(AdapterProcedure procedure, Object po, WLResponseListener adapterListener) throws Exception;

}