package ru.netology.fvd.moneytransferservice.repository;

import org.junit.Test;
import ru.netology.fvd.moneytransferservice.model.Amount;
import ru.netology.fvd.moneytransferservice.model.Operation;
import ru.netology.fvd.moneytransferservice.model.Transaction;
import ru.netology.fvd.moneytransferservice.model.Verification;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//{"cardFromNumber": "1231323123132131",
//  "cardToNumber": "5456465465465465",
//  "cardFromCVV": "111",
//  "cardFromValidTill": "06/23",
//  "amount": {
//    "currency": "RUR",
//    "value": 12300}
public class MoneyTransferRepositoryTest {
    private Amount amount= new Amount(10_000,"RUR");
    private Transaction transaction = new Transaction("1231323123132131", "10/25", "333", "5456465465465465", amount);
    private Verification verification = new Verification("1639758089D-1106446258", "1234");
    private Operation operation = new Operation(verification.getOperationId());
    private MoneyTransferRepository mts = new MoneyTransferRepository();

    @Test
    public void saveTransactionTest(){
        long unixTime = System.currentTimeMillis() / 1000L;
        String time = Long.toString(unixTime);
        String result = mts.saveTransaction(transaction);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(time)
                .append("D")
                .append(transaction.hashCode());
        assertTrue(result.equals(sBuilder.toString()));
    }

    @org.junit.jupiter.api.Test
    public void confirmOperationTest() {
        Operation testOperation = mts.confirmOperation(verification);
        assertSame(operation.getOperationId(), testOperation.getOperationId());
    }

    @org.junit.jupiter.api.Test
    public void confirmOperationTestWithMock() {
        Operation mockOperation = mock(Operation.class);
        when(mockOperation.getOperationId()).thenReturn("1639758089D-1106446258");
        String result = mockOperation.getOperationId();
        assertEquals(result, mts.confirmOperation(verification).getOperationId());
    }
}
