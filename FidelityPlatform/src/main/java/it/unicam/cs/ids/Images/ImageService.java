package it.unicam.cs.ids.Images;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ImageService {
    private final DBManager db;

    public ImageService() throws IOException {
        this.db = new DBManager();
    }

    public Image getImageFromID(String id) {
        return this.db.getImageFromID(id);
    }

    public void addImage(Image image){
        if(image.getId() == null){
            image.setId(UUID.randomUUID().toString());
        }
        if(image.getCreatedAt() == null){
            image.setCreatedAt(new Date());
        } else {
            image.setUpdatedAt(new Date());
        }
        db.registerImage(image);
    }

    public List<Image> getImagesByProductID(String productID) {
        try {
            return db.getImagesByProductID(productID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteImage(String id) {
        Image image = this.db.getImageFromID(id);
        if(image != null) {
            this.db.deleteImage(id);
        }
    }
    public Image getImageFromURL(String url){
        return this.db.getImageFromURL(url);
    }

    public void registerImages(List<Image> images) {
        String productID = images.get(0).getProductID();

        List<Image> existingImages = getImagesByProductID(productID);
        Set<String> existingImageURLs = existingImages.stream().map(Image::getUrl).collect(Collectors.toSet());
        for (Image existingImage : existingImages) {
            if (!images.contains(existingImage)) {
                deleteImage(existingImage.getId());
            }
        }
        for (Image image : images) {
            if (!existingImageURLs.contains(image.getUrl())) {
                addImage(image);
            }
        }
    }

    public void deleteProductImages(String productID) {
        List<Image> images = getImagesByProductID(productID);
        for(Image image:images){
            deleteImage(image.getId());
        }
    }
}
