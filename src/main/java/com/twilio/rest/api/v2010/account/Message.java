/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
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
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message extends Resource {
    private static final long serialVersionUID = 109887542891677L;

    public enum Status {
        QUEUED("queued"),
        SENDING("sending"),
        SENT("sent"),
        FAILED("failed"),
        DELIVERED("delivered"),
        UNDELIVERED("undelivered"),
        RECEIVING("receiving"),
        RECEIVED("received"),
        ACCEPTED("accepted"),
        SCHEDULED("scheduled"),
        READ("read");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    public enum Direction {
        INBOUND("inbound"),
        OUTBOUND_API("outbound-api"),
        OUTBOUND_CALL("outbound-call"),
        OUTBOUND_REPLY("outbound-reply");

        private final String value;

        private Direction(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Direction from a string.
         * @param value string value
         * @return generated Direction
         */
        @JsonCreator
        public static Direction forValue(final String value) {
            return Promoter.enumFromString(value, Direction.values());
        }
    }

    public enum ContentRetention {
        RETAIN("retain"),
        DISCARD("discard");

        private final String value;

        private ContentRetention(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ContentRetention from a string.
         * @param value string value
         * @return generated ContentRetention
         */
        @JsonCreator
        public static ContentRetention forValue(final String value) {
            return Promoter.enumFromString(value, ContentRetention.values());
        }
    }

    public enum AddressRetention {
        RETAIN("retain"),
        DISCARD("discard");

        private final String value;

        private AddressRetention(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a AddressRetention from a string.
         * @param value string value
         * @return generated AddressRetention
         */
        @JsonCreator
        public static AddressRetention forValue(final String value) {
            return Promoter.enumFromString(value, AddressRetention.values());
        }
    }

    public enum TrafficType {
        FREE("free");

        private final String value;

        private TrafficType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a TrafficType from a string.
         * @param value string value
         * @return generated TrafficType
         */
        @JsonCreator
        public static TrafficType forValue(final String value) {
            return Promoter.enumFromString(value, TrafficType.values());
        }
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final String pathAccountSid,
                                         final com.twilio.type.PhoneNumber to,
                                         final com.twilio.type.PhoneNumber from,
                                         final String body) {
        return new MessageCreator(pathAccountSid, to, from, body);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final com.twilio.type.PhoneNumber to,
                                         final com.twilio.type.PhoneNumber from,
                                         final String body) {
        return new MessageCreator(to, from, body);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media to send with the message
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final String pathAccountSid,
                                         final com.twilio.type.PhoneNumber to,
                                         final com.twilio.type.PhoneNumber from,
                                         final List<URI> mediaUrl) {
        return new MessageCreator(pathAccountSid, to, from, mediaUrl);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media to send with the message
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final com.twilio.type.PhoneNumber to,
                                         final com.twilio.type.PhoneNumber from,
                                         final List<URI> mediaUrl) {
        return new MessageCreator(to, from, mediaUrl);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final String pathAccountSid,
                                         final com.twilio.type.PhoneNumber to,
                                         final String messagingServiceSid,
                                         final String body) {
        return new MessageCreator(pathAccountSid, to, messagingServiceSid, body);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final com.twilio.type.PhoneNumber to,
                                         final String messagingServiceSid,
                                         final String body) {
        return new MessageCreator(to, messagingServiceSid, body);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param mediaUrl The URL of the media to send with the message
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final String pathAccountSid,
                                         final com.twilio.type.PhoneNumber to,
                                         final String messagingServiceSid,
                                         final List<URI> mediaUrl) {
        return new MessageCreator(pathAccountSid, to, messagingServiceSid, mediaUrl);
    }

    /**
     * Create a MessageCreator to execute create.
     *
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param mediaUrl The URL of the media to send with the message
     * @return MessageCreator capable of executing the create
     */
    public static MessageCreator creator(final com.twilio.type.PhoneNumber to,
                                         final String messagingServiceSid,
                                         final List<URI> mediaUrl) {
        return new MessageCreator(to, messagingServiceSid, mediaUrl);
    }

    /**
     * Create a MessageDeleter to execute delete.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       delete
     * @param pathSid The unique string that identifies the resource
     * @return MessageDeleter capable of executing the delete
     */
    public static MessageDeleter deleter(final String pathAccountSid,
                                         final String pathSid) {
        return new MessageDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a MessageDeleter to execute delete.
     *
     * @param pathSid The unique string that identifies the resource
     * @return MessageDeleter capable of executing the delete
     */
    public static MessageDeleter deleter(final String pathSid) {
        return new MessageDeleter(pathSid);
    }

    /**
     * Create a MessageFetcher to execute fetch.
     *
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathSid The unique string that identifies the resource
     * @return MessageFetcher capable of executing the fetch
     */
    public static MessageFetcher fetcher(final String pathAccountSid,
                                         final String pathSid) {
        return new MessageFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a MessageFetcher to execute fetch.
     *
     * @param pathSid The unique string that identifies the resource
     * @return MessageFetcher capable of executing the fetch
     */
    public static MessageFetcher fetcher(final String pathSid) {
        return new MessageFetcher(pathSid);
    }

    /**
     * Create a MessageReader to execute read.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @return MessageReader capable of executing the read
     */
    public static MessageReader reader(final String pathAccountSid) {
        return new MessageReader(pathAccountSid);
    }

    /**
     * Create a MessageReader to execute read.
     *
     * @return MessageReader capable of executing the read
     */
    public static MessageReader reader() {
        return new MessageReader();
    }

    /**
     * Create a MessageUpdater to execute update.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       update
     * @param pathSid The unique string that identifies the resource
     * @param body The text of the message you want to send
     * @return MessageUpdater capable of executing the update
     */
    public static MessageUpdater updater(final String pathAccountSid,
                                         final String pathSid,
                                         final String body) {
        return new MessageUpdater(pathAccountSid, pathSid, body);
    }

    /**
     * Create a MessageUpdater to execute update.
     *
     * @param pathSid The unique string that identifies the resource
     * @param body The text of the message you want to send
     * @return MessageUpdater capable of executing the update
     */
    public static MessageUpdater updater(final String pathSid,
                                         final String body) {
        return new MessageUpdater(pathSid, body);
    }

    /**
     * Converts a JSON String into a Message object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Message object represented by the provided JSON
     */
    public static Message fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Message object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Message object represented by the provided JSON
     */
    public static Message fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String body;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final DateTime dateSent;
    private final Message.Direction direction;
    private final Integer errorCode;
    private final String errorMessage;
    private final com.twilio.type.PhoneNumber from;
    private final String messagingServiceSid;
    private final String numMedia;
    private final String numSegments;
    private final String price;
    private final Currency priceUnit;
    private final String sid;
    private final Message.Status status;
    private final Map<String, String> subresourceUris;
    private final String to;
    private final String uri;

    @JsonCreator
    private Message(@JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("api_version")
                    final String apiVersion,
                    @JsonProperty("body")
                    final String body,
                    @JsonProperty("date_created")
                    final String dateCreated,
                    @JsonProperty("date_updated")
                    final String dateUpdated,
                    @JsonProperty("date_sent")
                    final String dateSent,
                    @JsonProperty("direction")
                    final Message.Direction direction,
                    @JsonProperty("error_code")
                    final Integer errorCode,
                    @JsonProperty("error_message")
                    final String errorMessage,
                    @JsonProperty("from")
                    final com.twilio.type.PhoneNumber from,
                    @JsonProperty("messaging_service_sid")
                    final String messagingServiceSid,
                    @JsonProperty("num_media")
                    final String numMedia,
                    @JsonProperty("num_segments")
                    final String numSegments,
                    @JsonProperty("price")
                    final String price,
                    @JsonProperty("price_unit")
                    @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                    final Currency priceUnit,
                    @JsonProperty("sid")
                    final String sid,
                    @JsonProperty("status")
                    final Message.Status status,
                    @JsonProperty("subresource_uris")
                    final Map<String, String> subresourceUris,
                    @JsonProperty("to")
                    final String to,
                    @JsonProperty("uri")
                    final String uri) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.body = body;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.dateSent = DateConverter.rfc2822DateTimeFromString(dateSent);
        this.direction = direction;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.from = from;
        this.messagingServiceSid = messagingServiceSid;
        this.numMedia = numMedia;
        this.numSegments = numSegments;
        this.price = price;
        this.priceUnit = priceUnit;
        this.sid = sid;
        this.status = status;
        this.subresourceUris = subresourceUris;
        this.to = to;
        this.uri = uri;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The API version used to process the message.
     *
     * @return The API version used to process the message
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The message text.
     *
     * @return The message text
     */
    public final String getBody() {
        return this.body;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was created.
     *
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was last
     * updated.
     *
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the message was sent.
     *
     * @return The RFC 2822 date and time in GMT when the message was sent
     */
    public final DateTime getDateSent() {
        return this.dateSent;
    }

    /**
     * Returns The The direction of the message.
     *
     * @return The direction of the message
     */
    public final Message.Direction getDirection() {
        return this.direction;
    }

    /**
     * Returns The The error code associated with the message.
     *
     * @return The error code associated with the message
     */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /**
     * Returns The The description of the error_code.
     *
     * @return The description of the error_code
     */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Returns The The phone number that initiated the message.
     *
     * @return The phone number that initiated the message
     */
    public final com.twilio.type.PhoneNumber getFrom() {
        return this.from;
    }

    /**
     * Returns The The SID of the Messaging Service used with the message..
     *
     * @return The SID of the Messaging Service used with the message.
     */
    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    /**
     * Returns The The number of media files associated with the message.
     *
     * @return The number of media files associated with the message
     */
    public final String getNumMedia() {
        return this.numMedia;
    }

    /**
     * Returns The The number of messages used to deliver the message body.
     *
     * @return The number of messages used to deliver the message body
     */
    public final String getNumSegments() {
        return this.numSegments;
    }

    /**
     * Returns The The amount billed for the message.
     *
     * @return The amount billed for the message
     */
    public final String getPrice() {
        return this.price;
    }

    /**
     * Returns The The currency in which price is measured.
     *
     * @return The currency in which price is measured
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The status of the message.
     *
     * @return The status of the message
     */
    public final Message.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The A list of related resources identified by their relative URIs.
     *
     * @return A list of related resources identified by their relative URIs
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    /**
     * Returns The The phone number that received the message.
     *
     * @return The phone number that received the message
     */
    public final String getTo() {
        return this.to;
    }

    /**
     * Returns The The URI of the resource, relative to `https://api.twilio.com`.
     *
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message other = (Message) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(apiVersion, other.apiVersion) &&
               Objects.equals(body, other.body) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(dateSent, other.dateSent) &&
               Objects.equals(direction, other.direction) &&
               Objects.equals(errorCode, other.errorCode) &&
               Objects.equals(errorMessage, other.errorMessage) &&
               Objects.equals(from, other.from) &&
               Objects.equals(messagingServiceSid, other.messagingServiceSid) &&
               Objects.equals(numMedia, other.numMedia) &&
               Objects.equals(numSegments, other.numSegments) &&
               Objects.equals(price, other.price) &&
               Objects.equals(priceUnit, other.priceUnit) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(status, other.status) &&
               Objects.equals(subresourceUris, other.subresourceUris) &&
               Objects.equals(to, other.to) &&
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            body,
                            dateCreated,
                            dateUpdated,
                            dateSent,
                            direction,
                            errorCode,
                            errorMessage,
                            from,
                            messagingServiceSid,
                            numMedia,
                            numSegments,
                            price,
                            priceUnit,
                            sid,
                            status,
                            subresourceUris,
                            to,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("body", body)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("dateSent", dateSent)
                          .add("direction", direction)
                          .add("errorCode", errorCode)
                          .add("errorMessage", errorMessage)
                          .add("from", from)
                          .add("messagingServiceSid", messagingServiceSid)
                          .add("numMedia", numMedia)
                          .add("numSegments", numSegments)
                          .add("price", price)
                          .add("priceUnit", priceUnit)
                          .add("sid", sid)
                          .add("status", status)
                          .add("subresourceUris", subresourceUris)
                          .add("to", to)
                          .add("uri", uri)
                          .toString();
    }
}