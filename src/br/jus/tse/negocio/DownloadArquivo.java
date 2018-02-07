package br.jus.tse.negocio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

public class DownloadArquivo {

    @SuppressWarnings("deprecation")
	private static byte[] executeRequest(HttpRequestBase requestBase) throws IOException
    {

        InputStream responseStream = null ;
        byte[] bytes = null;
    
        HttpClient client = HttpClients.createDefault();
        
        try{
            HttpResponse response = client.execute(requestBase) ;
        
            if (response != null)
            {
                HttpEntity responseEntity = response.getEntity() ;

                if (responseEntity != null)
                {
                    
                	responseStream = responseEntity.getContent() ;
                	bytes = IOUtils.toByteArray(responseStream);
                	//bytes = transforma(responseStream);
                }
            }
            
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }finally{
            if (responseStream != null){
                try {
                    responseStream.close() ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        client.getConnectionManager().shutdown() ;

        return bytes;
    }
    
    private static byte[] transforma(InputStream is){
    	
    			ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    			int nRead;
    			byte[] data = new byte[16384];

    			try {
					while ((nRead = is.read(data, 0, data.length)) != -1) {
					  buffer.write(data, 0, nRead);
						buffer.flush();

		    			return buffer.toByteArray();
					}
				} catch (IOException e) {					
					e.printStackTrace();
				}

    		return null;
    }

	public static byte [] efetuaDownload(String url, String id, String token) {	
        HttpGet getRequest;
		try {
			getRequest = new HttpGet (new StringBuilder(url).append("?id=").append(id.trim()).append("&token=").append(token.trim()).toString());
			return executeRequest (getRequest) ;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
	
}