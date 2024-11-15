package sap.pixelart.service;

import java.net.URI;

import sap.pixelart.service.application.PixelGridRegistryAsyncAPI;
import sap.pixelart.service.infrastructure.PixelGridRegistryProxy;

public class PixelGridLauncher {
		
	public static final String SERVICE_ADDRESS = "http://localhost:9100"; 
	public static final String REGISTRY_ADDRESS = "http://registry:9000"; 
	
    public static void main(String[] args) throws Exception {

    	var gridId = "my-grid-01";
    	
    	var serviceAddress = new URI(SERVICE_ADDRESS).toURL();    	
    	PixelGrid service = new PixelGrid(gridId, serviceAddress);
    	service.launch();
    	    	
    	var registryAddress = new URI(REGISTRY_ADDRESS).toURL(); 
    	System.out.println("Registry address: " + registryAddress);
    	PixelGridRegistryAsyncAPI registry = new PixelGridRegistryProxy(registryAddress);
    	tryToRegister(registry, gridId,1);
    }
    
    private static void tryToRegister(PixelGridRegistryAsyncAPI registry, String gridId, int ntimes) {
    	try {
    		var f = registry.registerPixelGrid(gridId, SERVICE_ADDRESS);
    		f.onFailure(s -> {
    			try {
    				Thread.sleep(1000);
    			} catch (Exception ex) {}
    			if (ntimes < 5) {
    				tryToRegister(registry, gridId, ntimes + 1);
    			}
    		});
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
