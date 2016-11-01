package com.kohls.mcommerce.opal.helper.adapter.rest;


import android.text.TextUtils;

import com.kohls.mcommerce.opal.common.po.CMSAdapterPO;
import com.kohls.mcommerce.opal.common.po.CategoryPO;
import com.kohls.mcommerce.opal.common.po.ConfigurationPO;
import com.kohls.mcommerce.opal.common.po.CreateProfilePO;
import com.kohls.mcommerce.opal.common.po.DeleteAddressPO;
import com.kohls.mcommerce.opal.common.po.FeatureBrandPO;
import com.kohls.mcommerce.opal.common.po.FlushCachePO;
import com.kohls.mcommerce.opal.common.po.ForgotPasswordPO;
import com.kohls.mcommerce.opal.common.po.GetCustomerProfilePO;
import com.kohls.mcommerce.opal.common.po.OffersPO;
import com.kohls.mcommerce.opal.common.po.PersistantGetCartPO;
import com.kohls.mcommerce.opal.common.po.PricingPO;
import com.kohls.mcommerce.opal.common.po.ProductDetailPO;
import com.kohls.mcommerce.opal.common.po.ProductMatrixPO;
import com.kohls.mcommerce.opal.common.po.RatingReviewPO;
import com.kohls.mcommerce.opal.common.po.RecommendationsPO;
import com.kohls.mcommerce.opal.common.po.ResetMyPasswordPO;
import com.kohls.mcommerce.opal.common.po.ServerLoggerPO;
import com.kohls.mcommerce.opal.common.po.SignInAndProfilePO;
import com.kohls.mcommerce.opal.common.po.SignInInfoPO;
import com.kohls.mcommerce.opal.common.po.StoreInventoryPO;
import com.kohls.mcommerce.opal.common.po.StoreLocatorPO;
import com.kohls.mcommerce.opal.common.po.TokenRegisrationPO;
import com.kohls.mcommerce.opal.common.po.UpdateCartPO;
import com.kohls.mcommerce.opal.common.po.UpdateShippingAddressPO;
import com.kohls.mcommerce.opal.common.po.ValidateOrderPO;
import com.kohls.mcommerce.opal.common.po.WriteReviewAuthorByIdPO;
import com.kohls.mcommerce.opal.common.po.WriteReviewPO;
import com.kohls.mcommerce.opal.common.util.NetworkUtils;
import com.kohls.mcommerce.opal.helper.adapter.AdapterProcedure;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponseListener;

import org.apache.http.message.BasicHeader;

import java.util.HashMap;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class RequestProcessor extends AbstractProcessor implements IRequestProcessor{

	private static final RequestProcessor INST = new RequestProcessor();

	private RequestProcessor(){
	}

	public static IRequestProcessor getInst() {
		return INST;
	}


	/**
	 * Request filter method.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean process(AdapterProcedure procedure, Object po, WLResponseListener adapterListener) throws Exception{

		if(procedure == null){
			throw new Exception("AdapterProcedure is null.");
		}
		if(po == null){
			throw new Exception("ParameterObject(PO) is null.");
		}
		if(adapterListener == null){
			throw new Exception("WLResponseListener is null.");
		}

		switch (procedure){
			case CACHE_FLUSH_API:
				this.getCacheFlushStatus(procedure,(FlushCachePO)po, adapterListener );
				break;
			case CALCULATE_ORDER:
				//this.calculateOrder(procedure, (CalculateOrderPO)po, adapterListener);
				break;
			case CLIENT_LOGGER:
				this.clientLogger(procedure, (ServerLoggerPO)po, adapterListener);
				break;
			case CMS_FEATURE_BRANDS:
				this.cmsContent(procedure, (FeatureBrandPO)po, adapterListener);
				break;
			case CMS_HELP_AND_CONTACT_US:
				this.cmsContent(procedure, (CMSAdapterPO)po, adapterListener);
				break;
			case CMS_HOME:
				this.cmsContent(procedure, (CMSAdapterPO)po, adapterListener);
				break;
			case CMS_LOYALTY_HELP:
				this.cmsContent(procedure, (CMSAdapterPO)po, adapterListener);
				break;
			case CONFIGURATION_DATA:
				this.getConfigurations(procedure, (ConfigurationPO)po, adapterListener);
				break;
			case CREATE_PROFILE:
				this.createProfile(procedure, (CreateProfilePO)po, adapterListener);
				break;

			case FORGOT_PASSWORD:
				this.forgotPassword(procedure, (ForgotPasswordPO)po, adapterListener);
				break;
			case GET_CART:
				this.getCart(procedure, (PersistantGetCartPO)po, adapterListener);
				break;
			case GET_CUSTOMER_PROFILE:
				this.getCustomerProfile(procedure,(GetCustomerProfilePO)po, adapterListener);
				break;
			case INVENTORY_BY_STORESEARCH:
				this.inventoryForProduct(procedure, (StoreInventoryPO)po, adapterListener);
				break;
			case PRICE_DETAILS:
				this.priceDetail(procedure, (PricingPO)po, adapterListener);
				break;
			case PRODUCT_DETAIL:
				this.productDetail(procedure, (ProductDetailPO)po, adapterListener);
				break;
			case PRODUCT_FOR_CATEGORYID:
				this.procuctForCategoryID(procedure, (CategoryPO)po, adapterListener);
				break;
			case PRODUCT_FOR_DEPARTMENTID:
				this.procuctForCategoryID(procedure, (CategoryPO)po, adapterListener);
				break;
			case PRODUCT_FOR_DIMENSIONS:
				this.productForDimensions(procedure, (ProductMatrixPO)po, adapterListener);
				break;

			case PRODUCT_OFFERS:
				this.productOffers(procedure,(OffersPO)po,adapterListener);
				break;
			case RATING_REVIEWS:
				this.ratingReviews(procedure, (RatingReviewPO)po, adapterListener);
				break;
			case RECOMMENDATION:
				this.recommendations(procedure, (RecommendationsPO)po, adapterListener);
				break;
			case SIGNIN_AND_PROFILE:
				this.signInProfile(procedure, (SignInAndProfilePO)po, adapterListener);
				break;
			case STORE_BY_OPENSEARCH:
				this.storeByOpenSearch(procedure, (StoreLocatorPO)po, adapterListener);
				break;
			case TOKEN_REGISRATION:
				this.tokenRegistration(procedure, (TokenRegisrationPO)po, adapterListener);
				break;
			case UPDATE_ACCOUNT:
				if (po instanceof ResetMyPasswordPO) {
					this.updateProfileInfo(procedure,(ResetMyPasswordPO)po, adapterListener);
				}else if (po instanceof SignInInfoPO) {
					this.updateProfileInfo(procedure,(SignInInfoPO)po, adapterListener);
				}
				break;
			case UPDATE_CART:
				this.updateCart(procedure,(UpdateCartPO)po, adapterListener);
				break;

			case WRITE_REVIEWS:
				this.writeReveiws(procedure, (WriteReviewPO)po, adapterListener);
				break;

			case WRITE_REVIEWS_GET_AUTHER:
				this.writeReveiwsGetAuther(procedure, (WriteReviewAuthorByIdPO)po, adapterListener);
				break;

			case UPDATE_SHIPPING_ADDRESS:
				this.updateShippingAddress(procedure, (UpdateShippingAddressPO)po, adapterListener);
				break;

			case VALIDATE_ORDER:
				this.validateOrder(procedure, (ValidateOrderPO)po, adapterListener);
				break;

			case DELETE_SHIPPING_ADDRESS:
				this.deleteShippingAddress(procedure, (DeleteAddressPO)po, adapterListener);
				break;

			case REGISTRY_LANDING_CMS:
				this.cmsContent(procedure, (CMSAdapterPO)po, adapterListener);
				break;
			default:
				break;

		}

		return true;
	}


	/**
	 * Deletes shipping address.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 */
	private void deleteShippingAddress(AdapterProcedure procedure,
									   DeleteAddressPO po, WLResponseListener adapterListener) {
		// TODO Auto-generated method stub

	}

	/**
	 * Validates order.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean validateOrder(AdapterProcedure procedure, ValidateOrderPO po,
								  WLResponseListener adapterListener) {
		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());

		wlReq.send(reqJson, adapterListener);

		return true;

	}

	/**
	 * Updates shipping address.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean updateShippingAddress(AdapterProcedure procedure,
										  UpdateShippingAddressPO po, WLResponseListener adapterListener) {
		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getAccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getAccess_token()));
		}

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());

		wlReq.send(reqJson, adapterListener);

		return true;

	}




	private boolean inventoryForProduct(AdapterProcedure procedure,
										StoreInventoryPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		if (po.getSku() != null) {
			stringUrl = stringUrl + "sku/" + po.getSku();
		}

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getchannel() != null) {
			wlReq.setQueryParameter("channel", po.getchannel());
		}

		if (po.getstoreNum() != null) {
			wlReq.setQueryParameter("storeNum", po.getstoreNum());
		}

		if (po.getLatitude() != null) {
			wlReq.setQueryParameter("latitude", po.getLatitude());
		}

		if (po.getLongitude() != null) {
			wlReq.setQueryParameter("longitude", po.getLongitude());
		}

		if (po.getRadius() != null) {
			wlReq.setQueryParameter("radius", po.getRadius());
		}


		wlReq.send(adapterListener);

		return true;

	}

	/**
	 * Requests cache flush data.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean getCacheFlushStatus(AdapterProcedure procedure,
										FlushCachePO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po != null && po.getparams() != null && po.getparams().getDataObject() != null) {
			for(Object value: po.getparams().getDataObject()){
				wlReq.setQueryParameter("cname", value.toString());
			}
		}

		wlReq.send(adapterListener);

		return true;

	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean tokenRegistration(AdapterProcedure procedure,
									  TokenRegisrationPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));

		HashMap<String, String> parametersMap = pojoToMap(po);

		wlReq.send(parametersMap, adapterListener);

		return true;
	}

	/**
	 * Updates profile info.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean updateProfileInfo(AdapterProcedure procedure, SignInInfoPO po,
									  WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getAccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getAccess_token()));
		}

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());

		wlReq.send(reqJson, adapterListener);

		return true;

	}

	/**
	 * Resets passwords.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean updateProfileInfo(AdapterProcedure procedure,
									  ResetMyPasswordPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getAccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getAccess_token()));
		}

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());

		wlReq.send(reqJson, adapterListener);

		return true;

	}

	/**
	 * Does server side logging.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean clientLogger(AdapterProcedure procedure, ServerLoggerPO po,
								 WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getPayload());

		wlReq.send(reqJson, adapterListener);

		return true;

	}

	/**
	 * Request for forgetting password.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean forgotPassword(AdapterProcedure procedure,
								   ForgotPasswordPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;

	}

	/**
	 * Requests configurations.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean getConfigurations(AdapterProcedure procedure,
									  ConfigurationPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;

	}

	/**
	 * Requests customer profile.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean getCustomerProfile(AdapterProcedure procedure,
									   GetCustomerProfilePO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getAccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getAccess_token()));
		}

		wlReq.send(adapterListener);

		return true;

	}

	/**
	 * Updates cart.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean updateCart(AdapterProcedure procedure, UpdateCartPO po,
							   WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getaccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getaccess_token()));
		}

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getparams());

		wlReq.send(reqJson, adapterListener);

		return true;

	}

	/**
	 * Requsets cart status.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private  boolean getCart(AdapterProcedure procedure, PersistantGetCartPO po,
							 WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getaccess_token() != null) {
			wlReq.setHeader(new BasicHeader("access_token", po.getaccess_token()));
		}

		wlReq.send(adapterListener);

		return true;

	}

	/**
	 * Requests product offers.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean productOffers(AdapterProcedure procedure, OffersPO po,
								  WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 * Requests product details.
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean productDetail(AdapterProcedure procedure, ProductDetailPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		if (po.getWebID() != null) {
			stringUrl = stringUrl + po.getWebID();
		}

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getSkuDetail()) {
			wlReq.setQueryParameter("skuDetail", po.getSkuDetail() +"");
		}

		if (po.getallSkus()) {
			wlReq.setQueryParameter("allSkus", po.getallSkus() + "");
		}

		if (po.getSkuCode() != null) {
			wlReq.setQueryParameter("skuCode", po.getSkuCode());
		}

		if (po.getUpc() != null) {
			wlReq.setQueryParameter("upc", po.getUpc());
		}

		wlReq.setHeader(new BasicHeader("Accept", "application/json"));

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 * Requests features brands.
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean cmsContent(AdapterProcedure procedure, FeatureBrandPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 * Requests cms content.
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean cmsContent(AdapterProcedure procedure, CMSAdapterPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 * Request catalogs
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean productForDimensions(AdapterProcedure procedure, ProductMatrixPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();
		if (po.getdimensionValueID() != null && po.getdimensionValueID().length == 0) {
			stringUrl = stringUrl +  '0';
		}else{
			if (po.getdimensionValueID() != null) {
				stringUrl = stringUrl + TextUtils.join("+", po.getdimensionValueID());
			}

		}

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		if (po.getKeyword() != null) {
			wlReq.setQueryParameter("keyword", po.getKeyword());
		}

		if (po.getlimit() != null) {
			wlReq.setQueryParameter("limit", po.getlimit());
		}

		if (po.getoffset() != null) {
			wlReq.setQueryParameter("offset", po.getoffset());
		}

		if (po.getsortID() != null) {
			wlReq.setQueryParameter("sortID", po.getsortID());
		}

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 * Requests recommendations.
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean recommendations(AdapterProcedure procedure,
									RecommendationsPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean priceDetail(AdapterProcedure procedure, PricingPO po,
								WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		if (po.getType() != null && po.getType().equals("webID")) {
			stringUrl = stringUrl + "webID/" + po.getParams().getPayload().getProducts().get(0).getID();
		}else if (po.getType() != null && po.getType().equals("sku")) {
			stringUrl = stringUrl + "sku/" + po.getParams().getPayload().getProducts().get(0).getID();
		}

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean signInProfile(AdapterProcedure procedure,
								  SignInAndProfilePO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));

		HashMap<String, String> parametersMap = pojoToMap(po);

		wlReq.send(parametersMap, adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean createProfile(AdapterProcedure procedure,
								  CreateProfilePO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));

		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());

		wlReq.send(reqJson, adapterListener);

		return true;
	}


	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

//	private boolean calculateOrder(AdapterProcedure procedure,
//								   CalculateOrderPO po, WLResponseListener adapterListener) {
//
//		String stringUrl = procedure.getURI();
//
//		if (po.isTrEnabled()) {
//			stringUrl = stringUrl + "?trEnabled=" + po.isTrEnabled();
//		}
//
//		String accessToken = KohlsPhoneApplication.getInstance()
//				.getAuthenticationUtils()
//				.getUserAccessTokenFromPref();
//
//		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());
//
//		if (null != accessToken && accessToken != "") {
//			wlReq.setHeader(new BasicHeader("access_token", accessToken ));
//		}
//
//		wlReq.setHeader(new BasicHeader("Content-Type", "application/json"));
//
//		String reqJson = NetworkUtils.createJsonFromModel(po.getParams());
//
//		wlReq.send(reqJson, adapterListener);
//
//		return true;
//
//	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean procuctForCategoryID(AdapterProcedure procedure,
										 CategoryPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		stringUrl = stringUrl + po.getCategoryID();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean storeByOpenSearch(AdapterProcedure procedure,
									  StoreLocatorPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */

	private boolean ratingReviews(AdapterProcedure procedure,
								  RatingReviewPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean writeReveiwsGetAuther(AdapterProcedure procedure,
										  WriteReviewAuthorByIdPO po, WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		this.setQueryParamaters(wlReq, po);

		wlReq.send(adapterListener);

		return true;
	}

	/**
	 *
	 * @param procedure
	 * @param po
	 * @param adapterListener
	 * @return
	 */
	private boolean writeReveiws(AdapterProcedure procedure, WriteReviewPO po,
								 WLResponseListener adapterListener) {

		String stringUrl = procedure.getURI();

		WLResourceRequest wlReq = createWLResourceRequest(stringUrl, procedure.getMethod());

		wlReq.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));

		wlReq.setQueryParameter("action", po.getAction());

		HashMap<String, String> parametersMap = pojoToMap(po.getPayload());

		wlReq.send(parametersMap, adapterListener);

		return true;

	}
}
