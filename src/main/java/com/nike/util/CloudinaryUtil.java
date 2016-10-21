package com.nike.util;

import com.cloudinary.*;
/**
 * Created by nike on 21.10.16.
 */
public class CloudinaryUtil {
    private static final Cloudinary cloudinary = initCloudi();

    private static Cloudinary initCloudi() {
        Cloudinary cloudinary = new Cloudinary("cloudinary://481389454822736:HTGJUMttEX4OukeUdWJfNifMne0@nike001");
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();
        return cloudinary;
    }

    public static Cloudinary getCloudinary() {
        return cloudinary;
    }
}
