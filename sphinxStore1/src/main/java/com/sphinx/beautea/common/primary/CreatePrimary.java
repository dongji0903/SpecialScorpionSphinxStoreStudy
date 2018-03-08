package com.sphinx.beautea.common.primary;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class CreatePrimary {
		private static CreatePrimary cp = new CreatePrimary();
		private CreatePrimary() {
			
		}
		
		public static CreatePrimary getInstance() {
			return cp;
		}

		/******************************
		 *                            *
		           프라이머리 key 생성!!     
		 *                            *
		 ******************************/	
	public String createPrimaryKey() {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("MMddHHmmssSS");
		
		String strDT = dayTime.format(new Date(time));
		
		return strDT;
	}
	
	/******************************
	 *                            *
	           쿠폰번호 생성 메서드!!!    
	 *                            *
	 ******************************/
	
	public String createCoupon() {
		Random random = new Random();
		String coupon = null;
		char ch = 0;
		List<String> chlist = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
		      ch = (char) ((Math.random() * 26) + 65);
		      chlist.add(String.valueOf(ch));
		}
		Collections.shuffle(chlist);
		
		int y = 0;
		while (true) {
			if (y < 6) {
				for (int i = 0; i < 2; i ++) {
					if (coupon == null) {
						coupon = chlist.get(y);
					} else {
						coupon = coupon + chlist.get(y);
					}
					y++;					
				}
				for (int i = 0; i < 2; i ++) {
					int x = random.nextInt(10);
					coupon = coupon + x;
					if (coupon.replace("-", "").length()%4 == 0) {
						coupon = coupon + "-";
					}
				}
			} else {
				break;
			}
		}
		
		coupon = coupon + chlist.get(6) + chlist.get(7) + chlist.get(8);
		
		for (int i = 0; i < 3; i++) {
			int x = random.nextInt(10);
			coupon = coupon + x;
		}
		
		return coupon;
	}
	
    /* **********************************************
	 * 자음 모음 분리
	 * 설연수 -> ㅅㅓㄹㅇㅕㄴㅅㅜ,    바보 -> ㅂㅏㅂㅗ
	 * **********************************************/
	/** 초성 - 가(ㄱ), 날(ㄴ) 닭(ㄷ) */
	public char[] arrChoSung = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138,
			0x3139, 0x3141, 0x3142, 0x3143, 0x3145, 0x3146, 0x3147, 0x3148,
			0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	/** 중성 - 가(ㅏ), 야(ㅑ), 뺨(ㅑ)*/
	public char[] arrJungSung = { 0x314f, 0x3150, 0x3151, 0x3152,
			0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158, 0x3159, 0x315a,
			0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162,
			0x3163 };
	/** 종성 - 가(없음), 갈(ㄹ) 천(ㄴ) */
	public char[] arrJongSung = { 0x0000, 0x3131, 0x3132, 0x3133,
			0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a, 0x313b, 0x313c,
			0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
			0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	
	
	/* **********************************************
	 * 알파벳으로 변환
	 * 설연수 -> tjfdustn, 멍충 -> ajdcnd 
	 * **********************************************/
	/** 초성 - 가(ㄱ), 날(ㄴ) 닭(ㄷ) */
	public String[] arrChoSungEng = { "g", "kk", "n", "d", "dd",
		"r", "m", "b", "bb", "s", "ss", "", "j",
		"jj", "ch", "k", "t", "p", "h" };
	
	/** 중성 - 가(ㅏ), 야(ㅑ), 뺨(ㅑ)*/
	public String[] arrJungSungEng = { "a", "ae", "ya", "yae",
		"eo", "e", "yeo", "ye", "o", "wa", "wae", "oe",
		"yo", "u", "wo", "weo", "wi", "yu", "eu", "ui",
		"i" };
	
	/** 종성 - 가(없음), 갈(ㄹ) 천(ㄴ) */
	public String[] arrJongSungEng = { "", "k", "k", "k",
		"n", "n", "n", "t", "l", "k", "l", "l",
		"t", "ch", "p", "l", "m", "p", "p", "t",
		"t", "ng", "t", "t", "k", "t", "p", "t" };
	
	/** 단일 자음 - ㄱ,ㄴ,ㄷ,ㄹ... (ㄸ,ㅃ,ㅉ은 단일자음(초성)으로 쓰이지만 단일자음으론 안쓰임) */
	public String[] arrSingleJaumEng = { "g", "kk", "k",
		"n", "n", "n", "d","tt" ,"r", "l", "l", "l",
		"l", "l", "l", "l", "m", "b","pp", "p", "ch",
		"ss", "y", "j", "jj", "ch", "k", "t", "p", "h" };
	
	
	
	public String CreateCategoryKeyworkd(String cName) {

		String word 		= cName;		// 분리할 단어
		String result		= "";									// 결과 저장할 변수
		String resultEng	= "";									// 알파벳으로
		
		for (int i = 0; i < word.length(); i++) {
			
			/*  한글자씩 읽어들인다. */
			char chars = (char) (word.charAt(i) - 0xAC00);

			if (chars >= 0 && chars <= 11172) {
				/* A. 자음과 모음이 합쳐진 글자인경우 */

				/* A-1. 초/중/종성 분리 */
				int chosung 	= chars / (21 * 28);
				int jungsung 	= chars % (21 * 28) / 28;
				int jongsung 	= chars % (21 * 28) % 28;

				
				/* A-2. result에 담기 */
				result = result + arrChoSung[chosung] + arrJungSung[jungsung];

				
				/* 자음분리 */
				if (jongsung != 0x0000) {
					/* A-3. 종성이 존재할경우 result에 담는다 */
					result =  result + arrJongSung[jongsung];
				}

				/* 알파벳으로 */
				resultEng = resultEng + arrChoSungEng[chosung] + arrJungSungEng[jungsung];
				if (jongsung != 0x0000) {
					/* A-3. 종성이 존재할경우 result에 담는다 */
					resultEng =  resultEng + arrJongSungEng[jongsung];
				}

			} else {
				/* B. 한글이 아니거나 자음만 있을경우 */

				/* 자음분리 */
				result = result + ((char)(chars + 0xAC00));
				
				/* 알파벳으로 */
				if( chars>=34097 && chars<=34126){
					/* 단일자음인 경우 */
					int jaum 	= (chars-34097);
					resultEng = resultEng + arrSingleJaumEng[jaum];
				} else if( chars>=34127 && chars<=34147) {
					/* 단일모음인 경우 */
					int moum 	= (chars-34127);
					resultEng = resultEng + arrJungSungEng[moum];
				} else {
					/* 알파벳인 경우 */
					resultEng = resultEng + ((char)(chars + 0xAC00));
				}
			}//if
			
		}//for
		
		return resultEng;
	}	
	
	public static void main(String[] args) {
		CreatePrimary c = CreatePrimary.getInstance();
		System.out.println(c.createPrimaryKey());
		System.out.println(c.CreateCategoryKeyworkd("한글을 영문으로 번역하기 테스트"));
	}
}
