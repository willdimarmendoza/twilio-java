/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.queue;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MemberFetcher extends Fetcher<Member> {
    private String pathAccountSid;
    private final String pathQueueSid;
    private final String pathCallSid;

    /**
     * Construct a new MemberFetcher.
     * 
     * @param pathQueueSid The SID of the Queue in which to find the members
     * @param pathCallSid The Call SID of the resource(s) to fetch
     */
    public MemberFetcher(final String pathQueueSid, 
                         final String pathCallSid) {
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
    }

    /**
     * Construct a new MemberFetcher.
     * 
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       fetch
     * @param pathQueueSid The SID of the Queue in which to find the members
     * @param pathCallSid The Call SID of the resource(s) to fetch
     */
    public MemberFetcher(final String pathAccountSid, 
                         final String pathQueueSid, 
                         final String pathCallSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Member
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Member fetch(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Queues/" + this.pathQueueSid + "/Members/" + this.pathCallSid + ".json",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Member fetch failed: Unable to connect to server");
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

        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }
}