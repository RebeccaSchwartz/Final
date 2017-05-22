package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {


private RateDomainModel rdm = new RateDomainModel();

	
	public RateException(RateDomainModel rdm){
		super();
		rdm=rdm;
	}
	
		public RateDomainModel getRateDomainModel(){
			return rdm;
	}


}
