package jp.pay.model;

import java.util.Map;

import jp.pay.Payjp;
import jp.pay.exception.APIConnectionException;
import jp.pay.exception.APIException;
import jp.pay.exception.AuthenticationException;
import jp.pay.exception.InvalidRequestException;
import jp.pay.net.RequestOptions;

public class CustomerCardCollection extends PayjpCollectionAPIResource<Card> {
  public CustomerCardCollection all(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, APIException {
    return all(params, (RequestOptions) null);
  }

  public CustomerCardCollection all(Map<String, Object> params,
      RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException,
      APIException {
    String url = String.format("%s%s", Payjp.getApiBase(), this.getURL());
	  return request(RequestMethod.GET, url, params, CustomerCardCollection.class, options);
  }

  public Card retrieve(String id)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, APIException {
    return retrieve(id, (RequestOptions) null);
  }

  public Card retrieve(String id, RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException,
      APIException {
    String url = String.format("%s%s/%s", Payjp.getApiBase(), this.getURL(), id);
	  return request(RequestMethod.GET, url, null, Card.class, options);
  }

  public Card create(Map<String, Object> params)
      throws AuthenticationException, InvalidRequestException,
      APIConnectionException, APIException {
    return create(params, (RequestOptions) null);
  }

  public Card create(Map<String, Object> params,
      RequestOptions options) throws AuthenticationException,
      InvalidRequestException, APIConnectionException,
      APIException {
    String url = String.format("%s%s", Payjp.getApiBase(), this.getURL());
	  return request(RequestMethod.POST, url, params, Card.class, options);
  }
}
