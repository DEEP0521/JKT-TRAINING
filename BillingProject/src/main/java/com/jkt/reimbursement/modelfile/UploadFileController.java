/*
 * package com.jkt.reimbursement.modelfile;
 * 
 * import java.io.File; import java.io.FileOutputStream; import
 * java.io.IOException; import java.util.ArrayList; import java.util.Arrays;
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.util.StringUtils; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 * 
 * import com.jkt.reimbursement.entity.Bill; import
 * com.jkt.reimbursement.service.BillService;
 * 
 * @RestController public class UploadFileController extends Bill {
 * 
 * @Autowired private BillService billservice;
 * 
 * @PostMapping("/file") public ResponseEntity UploadFile(@ModelAttribute Bill
 * bill ,@RequestParam("file") MultipartFile file) { Bill b=new Bill(); String
 * fileName=StringUtils.cleanPath(file.getOriginalFilename()); try {
 * b.setFile(file.getBytes()); } catch(IOException e) { e.printStackTrace(); }
 * Bill b1=new
 * Bill(bill.getType(),bill.getStart_date(),bill.getEnd_date(),bill.getFile());
 * //billservice.postBill(b1); String
 * fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path(
 * "/F:\\savedfiles").path(fileName).path("/db").toUriString(); return
 * ResponseEntity.ok(fileDownloadUri); }
 * 
 * }
 */