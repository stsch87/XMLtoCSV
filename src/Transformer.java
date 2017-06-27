import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Transformer {

    private static boolean bSalutation;
    private static boolean bFirstName;
    private static boolean bLastName;
    private static boolean bCompanyName;
    private static boolean bEmail;
    private static boolean bBilling;
    private static boolean bAddress1;
    private static boolean bAddress2;
    private static boolean bPostbox;
    private static boolean bZip;
    private static boolean bCity;
    private static boolean bCountry;
    private static boolean bBirthday;
    private static boolean bPhone;
    private static boolean bPhoneMobile;
    private static boolean bCustomerCardNo;
    private static boolean bCreationDate;
    private static boolean bCheckDateTime;
    private static boolean bCheckResult;
    private static boolean bLastOrderTime;
    private static boolean bAddresses;
	
	public static void main(String[] args) {
		String fileName = "./customers.xml";
		parseXML(fileName);
    }
 
    private static void parseXML(String fileName) {
        Customer cus = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
        	File fout = new File("customerexport.csv");
        	FileOutputStream fos = new FileOutputStream(fout);
         
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        	bw.write("CustomerNo|LastName|FirstName|Firma|Salutation|Email|" 
        	+"Address1|Address2|Postbox|Zip|City|Country|Birthday|Phone|"
        	+"PhoneMobile|CustomerCardNo|CreationDate|CheckDateTime|CheckResult|LastOrderTime");
        	bw.newLine();
        	
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            int event = xmlStreamReader.getEventType();
            while(true){
                switch(event) {
                case XMLStreamConstants.START_ELEMENT:
                
                	if(xmlStreamReader.getLocalName().equals("customer")){
                        cus = new Customer();
                        cus.setCustomerNo(xmlStreamReader.getAttributeValue(0));
                    }else if(xmlStreamReader.getLocalName().equals("addresses")){
                    	bAddresses = true;
                    }
                    else if(xmlStreamReader.getLocalName().equals("salutation") && !bAddresses){
                        bSalutation=true;                    
                    }else if(xmlStreamReader.getLocalName().equals("salutation")&& cus.getSalutation().equals("") && bBilling){
                    	bSalutation=true;
                    }else if(xmlStreamReader.getLocalName().equals("first-name")&& !bAddresses){
                        bFirstName=true;
                    }else if(xmlStreamReader.getLocalName().equals("first-name")&& cus.getFirstName().equals("") && bBilling){
                        bFirstName=true;
                    }else if(xmlStreamReader.getLocalName().equals("last-name")&& !bAddresses){
                        bLastName=true;
                    }else if(xmlStreamReader.getLocalName().equals("last-name")&& cus.getLastName().equals("") && bBilling){
                        bLastName=true;
                    }else if(xmlStreamReader.getLocalName().equals("company-name")&& !bAddresses){
                        bCompanyName=true;
                    }else if(xmlStreamReader.getLocalName().equals("company-name") && cus.getCompanyName().equals("") && cus.getSalutation().equals("Firma") && bBilling ){
                        bCompanyName=true;
                    }else if(xmlStreamReader.getLocalName().equals("email")){
                        bEmail=true;
                    }else if(xmlStreamReader.getLocalName().equals("address") && xmlStreamReader.getAttributeValue(1).equals("true") ){        	
                    		bBilling=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("address1")){
                        bAddress1=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("address2")){
                        bAddress2=true;
                    }else if(xmlStreamReader.getLocalName().equals("birthday")){
                        bBirthday=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("custom-attribute") &&  xmlStreamReader.getAttributeValue(0).equals("checkDateTime")){
                        bCheckDateTime=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("custom-attribute") &&  xmlStreamReader.getAttributeValue(0).equals("checkResult")){
                        bCheckResult=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("city")){
                        bCity=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("country-code")){
                        bCountry=true;
                    }else if(xmlStreamReader.getLocalName().equals("creation-date")){
                        bCreationDate=true;
                    }else if(xmlStreamReader.getLocalName().equals("custom-attribute") &&  xmlStreamReader.getAttributeValue(0).equals("kstCustomer")){
                        bCustomerCardNo=true;
                    }else if(xmlStreamReader.getLocalName().equals("custom-attribute") &&  xmlStreamReader.getAttributeValue(0).equals("lastOrderTime")){
                        bLastOrderTime=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("phone")){
                        bPhone=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("phoneMobile")){
                        bPhoneMobile=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("postBox")){
                        bPostbox=true;
                    }else if(bBilling && xmlStreamReader.getLocalName().equals("postal-code")){
                        bZip=true;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if(bSalutation){
                        cus.setSalutation(xmlStreamReader.getText().trim());
                        bSalutation=false;
                    }else if(bFirstName){
                        cus.setFirstName(xmlStreamReader.getText().trim());
                        bFirstName=false;
                    }else if(bLastName){
                        cus.setLastName(xmlStreamReader.getText().trim());
                        bLastName=false;
                    }else if(bCompanyName){
                        cus.setCompanyName(xmlStreamReader.getText().trim());
                        bCompanyName=false;
                    }else if(bEmail){
                        cus.setEmail(xmlStreamReader.getText().trim());
                        bEmail=false;
                    }else if(bAddress1){
                        cus.setAddress1(xmlStreamReader.getText().trim());
                        bAddress1=false;
                    }else if(bAddress2){
                        cus.setAddress2(xmlStreamReader.getText().trim());
                        bAddress2=false;
                    }else if(bBirthday){
                        cus.setBirthday(xmlStreamReader.getText().trim());
                        bBirthday=false;
                    }else if(bCheckDateTime){
                        cus.setCheckDateTime(xmlStreamReader.getText().trim());
                        bCheckDateTime=false;
                    }else if(bCheckResult){
                        cus.setCheckResult(xmlStreamReader.getText().trim());
                        bCheckResult=false;
                    }else if(bCity){
                        cus.setCity(xmlStreamReader.getText().trim());
                        bCity=false;
                    }else if(bCountry){
                        cus.setCountry(xmlStreamReader.getText().trim());
                        bCountry=false;
                    }else if(bCreationDate){
                        cus.setCreationDate(xmlStreamReader.getText().trim());
                        bCreationDate=false;
                    }else if(bCustomerCardNo){
                        cus.setCustomerCardNo(xmlStreamReader.getText().trim());
                        bCustomerCardNo=false;
                    }else if(bLastOrderTime){
                        cus.setLastOrderTime(xmlStreamReader.getText().trim());
                        bLastOrderTime=false;
                    }else if(bPhone){
                        cus.setPhone(xmlStreamReader.getText().trim());
                        bPhone=false;
                    }else if(bPhoneMobile){
                        cus.setPhoneMobile(xmlStreamReader.getText().trim());
                        bPhoneMobile=false;
                    }else if(bPostbox){
                        cus.setPostbox(xmlStreamReader.getText().trim());
                        bPostbox=false;
                    }else if(bZip){
                        cus.setZip(xmlStreamReader.getText().trim());
                        bZip=false;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if(xmlStreamReader.getLocalName().equals("address") && bBilling){
                    	bBilling=false;
                    }
                    if(xmlStreamReader.getLocalName().equals("addresses")){
                    	bAddresses=false;
                    }
                	if(xmlStreamReader.getLocalName().equals("customer")){
                     //   System.out.println(cus.toString());
                		bw.write(cus.toString());
                		bw.newLine();
                    }
                    
                    break;
                }
                if (!xmlStreamReader.hasNext())
                    break;
 
              event = xmlStreamReader.next();
            }

        	bw.close();    
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return;
    }

}
