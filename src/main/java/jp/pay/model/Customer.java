package jp.pay.model;

import java.util.HashMap;
import java.util.Map;

import jp.pay.exception.APIConnectionException;
import jp.pay.exception.APIException;
import jp.pay.exception.AuthenticationException;
import jp.pay.exception.InvalidRequestException;
import jp.pay.net.APIResource;
import jp.pay.net.RequestOptions;

public class Customer extends APIResource {
	CustomerCardCollection cards;
	Long created;	
	String defaultCard;	
	String description;
	String email;	
	String id;	
	Boolean livemode;
	CustomerSubscriptionCollection subscriptions;

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getLivemode() {
		return livemode;
	}

	public void setLivemode(Boolean livemode) {
		this.livemode = livemode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultCard() {
		return defaultCard;
	}

	public void setDefaultCard(String defaultCard) {
		this.defaultCard = defaultCard;
	}

	public CustomerCardCollection getCards() {
		return cards;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerSubscriptionCollection getSubscriptions() {
		return subscriptions;
	}

	public static Customer create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Customer retrieve(String id) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return retrieve(id, (RequestOptions) null);
	}

	public static CustomerCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return all(params, (RequestOptions) null);
	}

	public Customer update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return update(params, (RequestOptions) null);
	}

	public DeletedCustomer delete() throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return delete((RequestOptions) null);
	}

	public Card createCard(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return createCard(token, (RequestOptions) null);
	}

	public Card createCard(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return createCard(params, (RequestOptions) null);
	}

	public static Customer create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.POST, classURL(Customer.class), params, Customer.class, options);
	}

	public static Customer retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.GET, instanceURL(Customer.class, id), null, Customer.class, options);
	}

	public static CustomerCollection all(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return request(RequestMethod.GET, classURL(Customer.class), params, CustomerCollection.class, options);
	}

	public Customer update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.POST, instanceURL(Customer.class, this.id), params, Customer.class, options);
	}

	public DeletedCustomer delete(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.DELETE, instanceURL(Customer.class, this.id), null, DeletedCustomer.class, options);
	}

	public Card createCard(String token, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		Map<String, Object> postParams = new HashMap<String, Object>();
		postParams.put("card", token);

		return createCard(postParams, options);
	}

	public Card createCard(Map<String, Object> params, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return request(RequestMethod.POST, String.format("%s/cards",
						instanceURL(Customer.class, this.id)), params, Card.class, options);
	}

	public Subscription cancelSubscription(RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return cancelSubscription(null, options);
	}

	public Subscription cancelSubscription(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException,
			APIException {
		return request(RequestMethod.DELETE, String.format("%s/subscription",
						instanceURL(Customer.class, this.id)), params, Subscription.class, options);
	}
}
