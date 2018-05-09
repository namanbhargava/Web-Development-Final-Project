package in.developersera.encryption;

public class MyEncryption {
	
	
	
	public static String encPas(String pas)
	{
		String encPass = null;
		
		int hashValue = pas.hashCode();        
        String hash = String.valueOf(hashValue);
        
        int hashValue_1 = hash.hashCode();
        String hash_1 = String.valueOf(hashValue_1);
        
        int hashValue_2 = hash_1.hashCode();        
        String hash_2 = String.valueOf(hashValue_2);
        
        int hashValue_3 = hash_2.hashCode();
        encPass = String.valueOf(hashValue_3);
        
		return encPass;
	}
}
