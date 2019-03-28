/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class ServiceUpdater extends Updater<Service> {
    private final String pathSid;
    private String friendlyName;
    private Integer codeLength;
    private Boolean lookupEnabled;
    private Boolean skipSmsToLandlines;
    private Boolean dtmfInputRequired;
    private String ttsName;
    private Boolean psd2Enabled;

    /**
     * Construct a new ServiceUpdater.
     * 
     * @param pathSid Service Sid.
     */
    public ServiceUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * A 1-64 character string with friendly name of service.
     * 
     * @param friendlyName Friendly name of the service
     * @return this
     */
    public ServiceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The length of the verification code to be generated. Must be an integer value
     * between 4-10.
     * 
     * @param codeLength Length of verification code. Valid values are 4-10
     * @return this
     */
    public ServiceUpdater setCodeLength(final Integer codeLength) {
        this.codeLength = codeLength;
        return this;
    }

    /**
     * Boolean value that indicates if a lookup should be performed with each
     * verification started and associated info returned.
     * 
     * @param lookupEnabled Indicates whether or not to perform a lookup with each
     *                      verification started
     * @return this
     */
    public ServiceUpdater setLookupEnabled(final Boolean lookupEnabled) {
        this.lookupEnabled = lookupEnabled;
        return this;
    }

    /**
     * Boolean value that indicates whether or not to ignore SMS verifications for
     * landlines, depends on lookup_enabled flag.
     * 
     * @param skipSmsToLandlines Indicates whether or not to ignore SMS
     *                           verifications for landlines
     * @return this
     */
    public ServiceUpdater setSkipSmsToLandlines(final Boolean skipSmsToLandlines) {
        this.skipSmsToLandlines = skipSmsToLandlines;
        return this;
    }

    /**
     * Boolean value that indicates whether or not to require a random number input
     * to deliver the verify code via phone calls.
     * 
     * @param dtmfInputRequired Indicates whether or not to require a random number
     *                          input to deliver the verify code via phone calls
     * @return this
     */
    public ServiceUpdater setDtmfInputRequired(final Boolean dtmfInputRequired) {
        this.dtmfInputRequired = dtmfInputRequired;
        return this;
    }

    /**
     * Alternative to be used as Service friendly name in phone calls, only applies
     * to TTS languages.
     * 
     * @param ttsName Alternative to be used as Service friendly name in phone calls
     * @return this
     */
    public ServiceUpdater setTtsName(final String ttsName) {
        this.ttsName = ttsName;
        return this;
    }

    /**
     * Boolean value that enables to pass PSD2 transaction parameters when starting
     * a verification.
     * 
     * @param psd2Enabled Indicates whether PSD2 parameters are enabled or not
     * @return this
     */
    public ServiceUpdater setPsd2Enabled(final Boolean psd2Enabled) {
        this.psd2Enabled = psd2Enabled;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (codeLength != null) {
            request.addPostParam("CodeLength", codeLength.toString());
        }

        if (lookupEnabled != null) {
            request.addPostParam("LookupEnabled", lookupEnabled.toString());
        }

        if (skipSmsToLandlines != null) {
            request.addPostParam("SkipSmsToLandlines", skipSmsToLandlines.toString());
        }

        if (dtmfInputRequired != null) {
            request.addPostParam("DtmfInputRequired", dtmfInputRequired.toString());
        }

        if (ttsName != null) {
            request.addPostParam("TtsName", ttsName);
        }

        if (psd2Enabled != null) {
            request.addPostParam("Psd2Enabled", psd2Enabled.toString());
        }
    }
}