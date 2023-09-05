package it.unicam.cs.ids.BillBoard;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/billboard")
public class BillBoardController {
    private final BillBoardService service;
    @Autowired
    public BillBoardController(BillBoardService service){
        this.service = service;
    }

    @Operation(summary = "Get a BillBoard from its ID")
    @GetMapping("/{id}")
    public BillBoard getBillBoardFromID(@PathVariable String id){

        return this.service.getBillBoardFromID(id);
    }
    @PostMapping("/add")
    public void registerBillBoard(@RequestBody BillBoard billBoard){
        this.service.addBillBoard(billBoard);
    }




    @GetMapping("/{shopID}/all")
    public List<BillBoard> getShopBillBoards(@PathVariable String shopID){
        return this.service.getBillBoardsFromShopID(shopID);
    }
    @DeleteMapping("/{id}/delete")
    public void deleteBillBoard(@PathVariable String id){
        this.service.deleteBillBoard(id);
    }
}
