package it.unicam.cs.ids.BillBoard;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Billboard getBillBoardFromID(@PathVariable String id){

        return this.service.getBillBoardFromID(id);
    }
    @PostMapping("/add")
    public void registerBillBoard(@RequestBody Billboard billBoard){
        this.service.addBillBoard(billBoard);
    }




    @GetMapping("/{shopID}/all")
    public List<Billboard> getShopBillBoards(@PathVariable String shopID){
        return this.service.getBillBoardsFromShopID(shopID);
    }
    @DeleteMapping("/{shopID}/{id}/delete")
    public void deleteBillBoard(@PathVariable String id, @PathVariable String shopID){

        this.service.deleteBillBoard(id, shopID);
    }
}
