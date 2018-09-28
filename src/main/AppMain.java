package main;

import java.io.IOException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.http.HttpService;

public class AppMain {

	public static void main(String[] args) {
		
		Web3j web3j=Web3j.build(new HttpService("http://172.30.1.4:8545"));
		try {
			EthAccounts acc=web3j.ethAccounts().send();
			System.out.println("계정수 :  "+acc.getAccounts().size());
			
			EthMining ethMining=web3j.ethMining().send();
			System.out.println("현재 채굴여부 : "+ethMining.isMining());
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
