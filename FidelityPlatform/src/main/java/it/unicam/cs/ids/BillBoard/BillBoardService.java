package it.unicam.cs.ids.BillBoard;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class BillBoardService {
    private DBManager db;

    public BillBoardService() throws IOException {
        this.db = new DBManager();
    }

    public Billboard getBillBoardFromID(String id) {
       return  this.db.getBillBoardFromID(id);

    }

    public void addBillBoard(Billboard billBoard){
        if(billBoard.getID()==null){
            billBoard.setID(UUID.randomUUID().toString());
        }
        if(billBoard.getCreatedAt()==null){
            billBoard.setCreatedAt(new Date());
        }else{
            billBoard.setUpdatedAt(new Date());
        }
        db.registerBillBoard(billBoard);

    }

    public List<Billboard> getBillBoardsFromShopID(String shopID) {
        try {
            return db.getShopBillBoards(shopID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBillBoard(String id, String shopID) {
        Billboard billboard = this.db.getBillBoardFromID(id);
        if(billboard!=null && billboard.getStoreID().equals(shopID)) {
            this.db.deleteBillBoard(id);
        }
    }
}
