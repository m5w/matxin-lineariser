package util;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class DB {


	private static final String ARROW     = " -> ";
	private static final String LEER = "                            " ;
	private static final String BIG = "                                                                                    " ;

	private static boolean debug = true;

	final static public void println (Object err) {

		if (!debug) return;

		StackTraceElement[] ste = new Exception().getStackTrace();

		StringBuffer msg = new StringBuffer();
		msg.append((getDate().append(LEER).substring(0,10)));
		msg.append(' ');
		msg.append(ste[1].getClassName());
		msg.append('.');
		msg.append(ste[1].getMethodName());
		msg.append(':');
		msg.append(ste[1].getLineNumber());
	
	
	//	msg.append(ARROW);

		int l = 55-msg.length();
		if (l < 0) l =0;
		msg.append(BIG.substring(0, l));


//		if ((m_depth >= 0) && (m_depth < (BIG.length()) )) {
//		vDebugMessage.append(BIG.substring(0, m_depth*2));
//		}

		msg.append(err.toString());

		System.out.println(msg);


	}
	
	final static public void prints (String err) {

		if (!debug) return;
		System.out.println(err);


	}


	final private static StringBuffer getDate() {
//		if (Preferences.s_debug <= BDebug.FAIL) return s_sb;

		GregorianCalendar s_cal =  new GregorianCalendar();   
		StringBuffer sb = new StringBuffer();
//		sb.append(s_cal.get(Calendar.HOUR_OF_DAY));
//		sb.append('_');
		sb.append(s_cal.get(Calendar.MINUTE));
		sb.append('.');
		sb.append(s_cal.get(Calendar.SECOND));
		sb.append('.');
		sb.append(s_cal.get(Calendar.MILLISECOND));

		return sb;
	}

	public static void setDebug(boolean b) {
		debug=b;
		
	}

	final public static void error(String err) {
		if (!debug) return;
		StackTraceElement[] ste = new Exception().getStackTrace();

		StringBuffer msg = new StringBuffer();
		msg.append((getDate().append(LEER).substring(0,10)));
		msg.append(' ');
		msg.append(ste[1].getClassName());
		msg.append(':');
		msg.append(ste[1].getMethodName());
		msg.append(ARROW);

		int l = 55-msg.length();
		if (l < 0) l =0;
		msg.append(BIG.substring(0, l));


		msg.append(err.toString());

		System.out.println(msg);

		
	}


}
