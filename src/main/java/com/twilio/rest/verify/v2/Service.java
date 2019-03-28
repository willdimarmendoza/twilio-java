/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service extends Resource {
    private static final long serialVersionUID = 102125426973308L;

    /**
     * Create a ServiceCreator to execute create.
     * 
     * @param friendlyName Friendly name of the service
     * @return ServiceCreator capable of executing the create
     */
    public static ServiceCreator creator(final String friendlyName) {
        return new ServiceCreator(friendlyName);
    }

    /**
     * Create a ServiceFetcher to execute fetch.
     * 
     * @param pathSid Verification Service Instance SID.
     * @return ServiceFetcher capable of executing the fetch
     */
    public static ServiceFetcher fetcher(final String pathSid) {
        return new ServiceFetcher(pathSid);
    }

    /**
     * Create a ServiceDeleter to execute delete.
     * 
     * @param pathSid Verification Service Instance SID.
     * @return ServiceDeleter capable of executing the delete
     */
    public static ServiceDeleter deleter(final String pathSid) {
        return new ServiceDeleter(pathSid);
    }

    /**
     * Create a ServiceReader to execute read.
     * 
     * @return ServiceReader capable of executing the read
     */
    public static ServiceReader reader() {
        return new ServiceReader();
    }

    /**
     * Create a ServiceUpdater to execute update.
     * 
     * @param pathSid Service Sid.
     * @return ServiceUpdater capable of executing the update
     */
    public static ServiceUpdater updater(final String pathSid) {
        return new ServiceUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Service object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Service object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Service object represented by the provided JSON
     */
    public static Service fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final Integer codeLength;
    private final Boolean lookupEnabled;
    private final Boolean psd2Enabled;
    private final Boolean skipSmsToLandlines;
    private final Boolean dtmfInputRequired;
    private final String ttsName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Service(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("friendly_name")
                    final String friendlyName, 
                    @JsonProperty("code_length")
                    final Integer codeLength, 
                    @JsonProperty("lookup_enabled")
                    final Boolean lookupEnabled, 
                    @JsonProperty("psd2_enabled")
                    final Boolean psd2Enabled, 
                    @JsonProperty("skip_sms_to_landlines")
                    final Boolean skipSmsToLandlines, 
                    @JsonProperty("dtmf_input_required")
                    final Boolean dtmfInputRequired, 
                    @JsonProperty("tts_name")
                    final String ttsName, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("url")
                    final URI url, 
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.codeLength = codeLength;
        this.lookupEnabled = lookupEnabled;
        this.psd2Enabled = psd2Enabled;
        this.skipSmsToLandlines = skipSmsToLandlines;
        this.dtmfInputRequired = dtmfInputRequired;
        this.ttsName = ttsName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The A string that uniquely identifies this Service..
     * 
     * @return A string that uniquely identifies this Service.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Account Sid..
     * 
     * @return Account Sid.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Friendly name of the service.
     * 
     * @return Friendly name of the service
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The Length of verification code. Valid values are 4-10.
     * 
     * @return Length of verification code. Valid values are 4-10
     */
    public final Integer getCodeLength() {
        return this.codeLength;
    }

    /**
     * Returns The Indicates whether or not to perform a lookup with each
     * verification started.
     * 
     * @return Indicates whether or not to perform a lookup with each verification
     *         started
     */
    public final Boolean getLookupEnabled() {
        return this.lookupEnabled;
    }

    /**
     * Returns The Indicates whether PSD2 parameters are enabled or not.
     * 
     * @return Indicates whether PSD2 parameters are enabled or not
     */
    public final Boolean getPsd2Enabled() {
        return this.psd2Enabled;
    }

    /**
     * Returns The Indicates whether or not to ignore SMS verifications for
     * landlines.
     * 
     * @return Indicates whether or not to ignore SMS verifications for landlines
     */
    public final Boolean getSkipSmsToLandlines() {
        return this.skipSmsToLandlines;
    }

    /**
     * Returns The Indicates whether or not to require a random number input to
     * deliver the verify code via phone calls.
     * 
     * @return Indicates whether or not to require a random number input to deliver
     *         the verify code via phone calls
     */
    public final Boolean getDtmfInputRequired() {
        return this.dtmfInputRequired;
    }

    /**
     * Returns The Alternative to be used as Service friendly name in phone calls.
     * 
     * @return Alternative to be used as Service friendly name in phone calls
     */
    public final String getTtsName() {
        return this.ttsName;
    }

    /**
     * Returns The The date this Service was created.
     * 
     * @return The date this Service was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this Service was updated.
     * 
     * @return The date this Service was updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Service other = (Service) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(codeLength, other.codeLength) && 
               Objects.equals(lookupEnabled, other.lookupEnabled) && 
               Objects.equals(psd2Enabled, other.psd2Enabled) && 
               Objects.equals(skipSmsToLandlines, other.skipSmsToLandlines) && 
               Objects.equals(dtmfInputRequired, other.dtmfInputRequired) && 
               Objects.equals(ttsName, other.ttsName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            friendlyName,
                            codeLength,
                            lookupEnabled,
                            psd2Enabled,
                            skipSmsToLandlines,
                            dtmfInputRequired,
                            ttsName,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("friendlyName", friendlyName)
                          .add("codeLength", codeLength)
                          .add("lookupEnabled", lookupEnabled)
                          .add("psd2Enabled", psd2Enabled)
                          .add("skipSmsToLandlines", skipSmsToLandlines)
                          .add("dtmfInputRequired", dtmfInputRequired)
                          .add("ttsName", ttsName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}