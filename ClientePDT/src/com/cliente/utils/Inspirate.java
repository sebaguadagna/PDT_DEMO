package com.cliente.utils;

import javax.swing.JLabel;

public class Inspirate {

	private String message;
	

	public static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public Inspirate(String m) {
		this.message = m;
	}

	public JLabel getMessageJLabelFormat() {
		
		JLabel jl = new JLabel();
		
		if(this.message.length()>40) {
			for(int i=(this.message.length()/3);i<this.message.length();i++) {
				if(this.message.charAt(i)==' ') {
					StringBuilder messageA = new StringBuilder();
					StringBuilder messageB = new StringBuilder();
					
					for(int j=i;j<this.message.length();j++ ) {
						messageB.append(this.message.charAt(j));
					}
					for(int z=0;z<i;z++) {
						messageA.append(this.message.charAt(z));
					}
					jl = new JLabel("<html><center>" + messageA.toString() + "<br>"
							+ messageB.toString());
					break;
				}
			}
		}else {
			jl = new JLabel("<html><center>" + this.message);
		}
		return jl;
	}
	

	
	public String getMessage() {
		return message;
	}

	public String setMessage(String m) {
		return message;
	}


}
