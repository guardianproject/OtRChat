package net.java.otr4j.crypto;

import java.security.KeyPair;

import net.java.otr4j.session.SessionID;

public class KeyAndSession {

	private KeyPair myKeyPair;
	private SessionID mySessionID;
	
	public KeyAndSession(KeyPair kp, SessionID si){
		myKeyPair = kp;
		mySessionID = si;
	}
	
	public KeyPair getKeyPair(){
		return myKeyPair;
	}
	public SessionID getSessionID(){
		return mySessionID;
	}
}
