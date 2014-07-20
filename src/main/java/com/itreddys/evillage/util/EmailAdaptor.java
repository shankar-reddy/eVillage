package com.itreddys.evillage.util;

import com.itreddys.evillage.exception.eVillageException;

/*
 * Deals with Email related stuff.
 */
public interface EmailAdaptor extends Adaptor{
		public String sendMail(EmailMessage message) throws eVillageException;	
}
