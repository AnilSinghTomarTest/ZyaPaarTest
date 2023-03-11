package com.example.ZyaPaarTest.conroller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZyaPaarTest.entities.InventoryEntity;
import com.example.ZyaPaarTest.repository.InventoryRepository;

@RestController
public class InventoryController {
	
	@Autowired
	public InventoryRepository inventoryrepository;
	
		@PostMapping("/stock")
		public    String addStock(@RequestBody InventoryEntity inventoryentity)
		{
			inventoryrepository.save(inventoryentity);
		    return "Added";
		}
		
		@GetMapping("/stock")
	public  Iterable<InventoryEntity> getstock()
	{	
		
		return inventoryrepository.findAll();
	}
		
		@GetMapping("/stock/{id}")
		public  Optional<InventoryEntity> getStock(@PathVariable("id") int id)
		{
			//return this.bookService.getBookById(id);
			return inventoryrepository.findById(id);
		}	
		
		
		@DeleteMapping("/stock/{stockId}")
		public String deleteBook(@PathVariable("stockId") int Id)
		{
			
			inventoryrepository.deleteById(Id);
			return "Deleted";
		}
		
		@PutMapping("/stock/{stockId}")
		public   InventoryEntity updateStock(@RequestBody InventoryEntity inventoryentity,@PathVariable("stockId") int stockId)
		{
//			this.bookService.updateBook(book, bookId);
//			return book;
//			InventoryEntity i;
//			
//			i= inventoryrepository.findById(stockId).stream().map(b->{
//					if(b.getId()==stockId)
//				{
//						b.setItem(inventoryentity.getItem());
//						b.setstock(inventoryentity.getstock());
//					}
//				
//			});
			 
		//		 return "Updated";
			
//			inventoryrepository.findById(stockId).map(InventoryEntity -> {
//				InventoryEntity.setItem(inventoryentity.getItem());
//				InventoryEntity.setstock(inventoryentity.getstock());
//		      //  return repository.save(employee);
//		      })
//		      .orElseGet(() -> {
//		    	  inventoryentity.setId(stockId);
//		        return repository.save(inventoryentity);
//		      });
			
//			Optional<InventoryEntity> optional=inventoryrepository.findById(stockId);
//			InventoryEntity updaterecord=optional.get();
//			if (updaterecord.isPresent()) {
//				InventoryEntity inventoryentity1 = updaterecord.get();
//
//                // loop through the map keys here and only update the values that are present in the map. 
//
//                logger.info("restaurant information edited successfully");
//                return restaurantService.save(restaurant);
//            } else
//                return null;
			
			   Optional<InventoryEntity> inventoryOptional = inventoryrepository.findById(stockId);

			    if (inventoryOptional.isPresent()) {
			        InventoryEntity restaurant = inventoryOptional.get();
			        restaurant.setItem(inventoryentity.getItem());
			        restaurant.setstock(restaurant.getstock());

			      //  logger.info("restaurant information edited successfully");
			        return inventoryrepository.save(restaurant);
			    } else
			        return null;
			
			
		}


}
