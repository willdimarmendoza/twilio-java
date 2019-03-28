/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Creator;
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
public class VerificationCreator extends Creator<Verification> {
    private final String pathServiceSid;
    private final String to;
    private final String channel;
    private String customMessage;
    private String sendDigits;
    private String locale;
    private String customCode;
    private String amount;
    private String payee;

    /**
     * Construct a new VerificationCreator.
     * 
     * @param pathServiceSid Service Sid.
     * @param to To phonenumber
     * @param channel sms or call
     */
    public VerificationCreator(final String pathServiceSid, 
                               final String to, 
                               final String channel) {
        this.pathServiceSid = pathServiceSid;
        this.to = to;
        this.channel = channel;
    }

    /**
     * A character string containing a custom message for this verification.
     * 
     * @param customMessage A custom message for this verification
     * @return this
     */
    public VerificationCreator setCustomMessage(final String customMessage) {
        this.customMessage = customMessage;
        return this;
    }

    /**
     * Digits to send when a phone call is started, same parameters as in
     * Programmable Voice are supported.
     * 
     * @param sendDigits Digits to send when a phone call is started
     * @return this
     */
    public VerificationCreator setSendDigits(final String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    /**
     * Supported values are af, ar, ca, cs, da, de, el, en, es, fi, fr, he, hi, hr,
     * hu, id, it, ja, ko, ms, nb, nl, pl, pt, pr-BR, ro, ru, sv, th, tl, tr, vi,
     * zh, zh-CN, zh-HK.
     * 
     * @param locale Locale used in the sms or call.
     * @return this
     */
    public VerificationCreator setLocale(final String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * Pass in a pre-generated code. Code length can be between 4-10 characters..
     * 
     * @param customCode A pre-generated code
     * @return this
     */
    public VerificationCreator setCustomCode(final String customCode) {
        this.customCode = customCode;
        return this;
    }

    /**
     * Amount of the associated PSD2 compliant transaction. Requires the PSD2
     * Service flag enabled..
     * 
     * @param amount Amount of the associated PSD2 compliant transaction.
     * @return this
     */
    public VerificationCreator setAmount(final String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Payee of the associated PSD2 compliant transaction. Requires the PSD2 Service
     * flag enabled..
     * 
     * @param payee Payee of the associated PSD2 compliant transaction.
     * @return this
     */
    public VerificationCreator setPayee(final String payee) {
        this.payee = payee;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Verification
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Verification create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Verifications",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Verification creation failed: Unable to connect to server");
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

        return Verification.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to);
        }

        if (channel != null) {
            request.addPostParam("Channel", channel);
        }

        if (customMessage != null) {
            request.addPostParam("CustomMessage", customMessage);
        }

        if (sendDigits != null) {
            request.addPostParam("SendDigits", sendDigits);
        }

        if (locale != null) {
            request.addPostParam("Locale", locale);
        }

        if (customCode != null) {
            request.addPostParam("CustomCode", customCode);
        }

        if (amount != null) {
            request.addPostParam("Amount", amount);
        }

        if (payee != null) {
            request.addPostParam("Payee", payee);
        }
    }
}