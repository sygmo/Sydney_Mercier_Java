package com.trilogyed.gamestoreinvoicing.repository;

import com.trilogyed.gamestoreinvoicing.model.Invoice;
import com.trilogyed.gamestoreinvoicing.model.ProcessingFee;
import com.trilogyed.gamestoreinvoicing.model.TShirt;
import com.trilogyed.gamestoreinvoicing.model.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    TaxRepository taxRepository;
    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
        processingFeeRepository.deleteAll();

        ProcessingFee tShirtProcessingFee = new ProcessingFee();
        tShirtProcessingFee.setProductType("T-Shirts");
        tShirtProcessingFee.setFee(new BigDecimal("1.98"));

        ProcessingFee consoleProcessingFee = new ProcessingFee();
        consoleProcessingFee.setProductType("Consoles");
        consoleProcessingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee gameProcessingFee = new ProcessingFee();
        gameProcessingFee.setProductType("Games");
        gameProcessingFee.setFee(new BigDecimal("1.49"));

        processingFeeRepository.save(tShirtProcessingFee);
        processingFeeRepository.save(consoleProcessingFee);
        processingFeeRepository.save(gameProcessingFee);
    }

    @Test
    public void shouldAddFindDeleteInvoice() {
        Invoice invoice1 = new Invoice();
        invoice1.setName("Joe Black");
        invoice1.setStreet("123 Main St");
        invoice1.setCity("any City");
        invoice1.setState("NY");
        invoice1.setZipcode("10016");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(5);
        invoice1.setUnitPrice(new BigDecimal("15.99"));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("31.98"));

        Optional<Tax> tax = taxRepository.findById(invoice1.getState());
        assertTrue(tax.isPresent());
        invoice1.setTax(invoice1.getSubtotal().multiply(tax.get().getRate()));

        Optional<ProcessingFee> processingFee = processingFeeRepository.findById(invoice1.getItemType());
        assertTrue(processingFee.isPresent());
        invoice1.setProcessingFee(processingFee.get().getFee());

        invoice1.setTotal(invoice1.getSubtotal().add(invoice1.getTax()).add(invoice1.getProcessingFee()));

        //Act
        invoice1 = invoiceRepository.save(invoice1);
        Optional<Invoice> invoice2 = invoiceRepository.findById(invoice1.getId());

        //Assert
        assertTrue(invoice2.isPresent());
        assertEquals(invoice1, invoice2.get());

        //Act
        invoiceRepository.deleteById(invoice1.getId());
        invoice2 = invoiceRepository.findById(invoice1.getId());

        //Assert
        assertFalse(invoice2.isPresent());
    }

    @Test
    public void shouldFindByName() {
        Invoice invoice1 = new Invoice();
        invoice1.setName("Joe Black");
        invoice1.setStreet("123 Main St");
        invoice1.setCity("any City");
        invoice1.setState("NY");
        invoice1.setZipcode("10016");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(5);
        invoice1.setUnitPrice(new BigDecimal("15.99"));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("31.98"));

        Optional<Tax> tax = taxRepository.findById(invoice1.getState());
        assertTrue(tax.isPresent());
        invoice1.setTax(invoice1.getSubtotal().multiply(tax.get().getRate()));

        Optional<ProcessingFee> processingFee = processingFeeRepository.findById(invoice1.getItemType());
        assertTrue(processingFee.isPresent());
        invoice1.setProcessingFee(processingFee.get().getFee());

        invoice1.setTotal(invoice1.getSubtotal().add(invoice1.getTax()).add(invoice1.getProcessingFee()));

        //Act
        invoice1 = invoiceRepository.save(invoice1);

        List<Invoice> foundNoinvoice = invoiceRepository.findByName("invalidValue");

        List<Invoice> foundOneinvoice = invoiceRepository.findByName(invoice1.getName());

        //Assert
        assertEquals(foundOneinvoice.size(),1);

        //Assert
        assertEquals(foundNoinvoice.size(),0);
    }
}