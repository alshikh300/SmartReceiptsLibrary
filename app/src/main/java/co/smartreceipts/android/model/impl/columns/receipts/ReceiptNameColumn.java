package co.smartreceipts.android.model.impl.columns.receipts;

import android.support.annotation.NonNull;

import co.smartreceipts.android.model.Receipt;
import co.smartreceipts.android.model.impl.columns.AbstractColumnImpl;
import co.smartreceipts.android.sync.model.SyncState;

/**
 * Provides a column that returns the category code for a particular receipt
 */
public final class ReceiptNameColumn extends AbstractColumnImpl<Receipt> {

    public ReceiptNameColumn(int id, @NonNull String name, @NonNull SyncState syncState) {
        super(id, name, syncState);
    }

    @Override
    public String getValue(@NonNull Receipt receipt) {
        return receipt.getName();
    }
}