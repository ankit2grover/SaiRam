
package com.kohls.mcommerce.opal.helper.adapter;

import com.kohls.mcommerce.opal.framework.vo.AuthorsByIdsVO;
import com.kohls.mcommerce.opal.framework.vo.CMSResponseVO;
import com.kohls.mcommerce.opal.framework.vo.CalculateOrderVO;
import com.kohls.mcommerce.opal.framework.vo.CategoryVO;
import com.kohls.mcommerce.opal.framework.vo.ConfigurationVO;
import com.kohls.mcommerce.opal.framework.vo.CreateProfileVO;
import com.kohls.mcommerce.opal.framework.vo.FlushdataVO;
import com.kohls.mcommerce.opal.framework.vo.ForgotPasswordVO;
import com.kohls.mcommerce.opal.framework.vo.GetCustomerProfileVO;
import com.kohls.mcommerce.opal.framework.vo.HelpContactUsVO;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.framework.vo.LoyaltyHelpVO;
import com.kohls.mcommerce.opal.framework.vo.OffersVO;
import com.kohls.mcommerce.opal.framework.vo.PersistentGetCartVO;
import com.kohls.mcommerce.opal.framework.vo.PricingVO;
import com.kohls.mcommerce.opal.framework.vo.ProductDetailVO;
import com.kohls.mcommerce.opal.framework.vo.ProductMatrixVO;
import com.kohls.mcommerce.opal.framework.vo.RecommendationsVO;
import com.kohls.mcommerce.opal.framework.vo.RegistryResponseVO;
import com.kohls.mcommerce.opal.framework.vo.SignInAndProfileVO;
import com.kohls.mcommerce.opal.framework.vo.StoreInventoryVO;
import com.kohls.mcommerce.opal.framework.vo.StoreLocatorVO;
import com.kohls.mcommerce.opal.framework.vo.SubCategoryVO;
import com.kohls.mcommerce.opal.framework.vo.TokenRegisrationVO;
import com.kohls.mcommerce.opal.framework.vo.UpdateAccountVO;
import com.kohls.mcommerce.opal.framework.vo.UpdateCartVO;
import com.kohls.mcommerce.opal.framework.vo.WriteReviewVO;
import com.kohls.mcommerce.opal.modules.lnr.framework.vo.DeleteShippingAddressVO;
import com.kohls.mcommerce.opal.modules.lnr.framework.vo.UpdateShippingAddressVO;
import com.kohls.mcommerce.opal.modules.lnr.framework.vo.ValidateOrderVO;
import com.worklight.wlclient.api.WLResourceRequest;

/**
 * Enum to represent different procedures of adapter.
 */
public enum AdapterProcedure {

    PRODUCT_DETAIL(WLResourceRequest.GET, "/adapters/rest/v1/products/", ProductDetailVO.class),

    PRICE_DETAILS(WLResourceRequest.GET, "/adapters/rest/v1/price/", PricingVO.class),

    CMS_HOME(WLResourceRequest.GET, "/adapters/rest/v1/cms", CMSResponseVO.class),

    PRODUCT_FOR_DIMENSIONS(WLResourceRequest.GET,
            "/adapters/rest/v1/catalog/",
            ProductMatrixVO.class),

    SIGNIN_AND_PROFILE(WLResourceRequest.POST,
            "/adapters/rest/v1/auth/signInProfile",
            SignInAndProfileVO.class),

    CREATE_PROFILE(WLResourceRequest.POST, "/adapters/rest/v1/profile", CreateProfileVO.class),

    PRODUCT_FOR_CATEGORYID(WLResourceRequest.GET,
            "/adapters/rest/v1/catalog/category/",
            CategoryVO.class),

    PRODUCT_FOR_DEPARTMENTID(WLResourceRequest.GET,
            "/adapters/rest/v1/catalog/category/",
            SubCategoryVO.class),

    RECOMMENDATION(WLResourceRequest.GET,
            "/adapters/rest/v1/recommendation",
            RecommendationsVO.class),

    CALCULATE_ORDER(WLResourceRequest.POST,
            "/adapters/rest/v1/order/calculation",
            CalculateOrderVO.class),

    CMS_HELP_AND_CONTACT_US(WLResourceRequest.GET, "/adapters/rest/v1/cms", HelpContactUsVO.class),

    CMS_LOYALTY_HELP(WLResourceRequest.GET, "/adapters/rest/v1/cms", LoyaltyHelpVO.class),

    CMS_FEATURE_BRANDS(WLResourceRequest.GET, "/adapters/rest/v1/cms"),

    STORE_BY_OPENSEARCH(WLResourceRequest.GET, "/adapters/rest/v1/stores", StoreLocatorVO.class),

    FORGOT_PASSWORD(WLResourceRequest.GET,
            "/adapters/rest/v1/profile/forgotPassword",
            ForgotPasswordVO.class),

    WRITE_REVIEWS_GET_AUTHER(WLResourceRequest.GET,
            "/adapters/rest/v1/bzv/reviews",
            AuthorsByIdsVO.class),

    RATING_REVIEWS(WLResourceRequest.GET, "/adapters/rest/v1/bzv/reviews"),

    WRITE_REVIEWS(WLResourceRequest.POST, "/adapters/rest/v1/bzv/reviews", WriteReviewVO.class),

    PRODUCT_OFFERS(WLResourceRequest.GET, "/adapters/rest/v1/offers/product", OffersVO.class),

    GET_CUSTOMER_PROFILE(WLResourceRequest.GET,
            "/adapters/rest/v1/profile",
            GetCustomerProfileVO.class),

    CONFIGURATION_DATA(WLResourceRequest.GET,
            "/adapters/rest/v1/configures/client",
            ConfigurationVO.class),

    GET_CART(WLResourceRequest.GET, "/adapters/rest/v1/cart", PersistentGetCartVO.class),

    UPDATE_CART(WLResourceRequest.POST, "/adapters/rest/v1/cart", UpdateCartVO.class),

    INVENTORY_BY_STORESEARCH(WLResourceRequest.GET,
            "/adapters/rest/v1/inventory/",
            StoreInventoryVO.class),

    TOKEN_REGISRATION(WLResourceRequest.POST,
            "/adapters/rest/v1/auth/token",
            TokenRegisrationVO.class),

    UPDATE_ACCOUNT(WLResourceRequest.PUT, "/adapters/rest/v1/profile", UpdateAccountVO.class),

    CACHE_FLUSH_API(WLResourceRequest.GET, "/adapters/rest/v1/caching/stats", FlushdataVO.class),

    CLIENT_LOGGER(WLResourceRequest.POST, "/adapters/rest/v1/clientLogger"),

    DELETE_SHIPPING_ADDRESS(WLResourceRequest.POST,
            "/adapters/rest/v1/profile/shipAddress/",
            DeleteShippingAddressVO.class),

    VALIDATE_ORDER(WLResourceRequest.POST, "/adapters/rest/v1/validation", ValidateOrderVO.class),

    UPDATE_SHIPPING_ADDRESS(WLResourceRequest.POST,
            "/adapters/rest/v1/profile/shipAddress",
            UpdateShippingAddressVO.class),

    REGISTRY_LANDING_CMS(WLResourceRequest.GET, "/adapters/rest/v1/cms", RegistryResponseVO.class);

    private static final String ADAPTER_NAME = "RESTAdapter";

    // The HTTP method of this call
    private String mMethod = null;

    // Relative URI of the adapter resource
    private String mURI = null;

    // Value Object Class
    private Class<? extends IValueObject> mValueObjectClass;

    private AdapterProcedure(final String httpMethod,
            final String resourceURI,
            Class<? extends IValueObject> valueObjectClass) {
        this.mMethod = httpMethod;
        this.mURI = resourceURI;
        this.mValueObjectClass = valueObjectClass;
    }

    private AdapterProcedure(final String httpMethod, final String resourceURI) {
        this.mMethod = httpMethod;
        this.mURI = resourceURI;
    }

    /**
     * Set class for value object
     * 
     * @param valueObjectClass class of value object.
     */
    public void setValueObjectClass(Class<? extends IValueObject> valueObjectClass) {
        mValueObjectClass = valueObjectClass;
    }

    /**
     * Return Value Object of the procedure.
     */
    public Class<? extends IValueObject> getValueObjectClass() {
        return mValueObjectClass;
    }

    public String getURI() {
        return mURI;
    }

    public String getMethod() {
        return mMethod;
    }

    public String getProcedureName() {
        return mURI;
    }

    public String getAdapterName() {
        return ADAPTER_NAME;
    }

}
