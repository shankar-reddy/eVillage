
package com.itreddys.evillage.util;

import com.itreddys.evillage.exception.eVillageException;

public interface SMSAdaptor extends Adaptor {
	public String sendSMS(SMSMessage smsMessage) throws eVillageException;
}
