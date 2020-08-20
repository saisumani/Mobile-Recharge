package com.capg.mra.mobilerechargeapplication.service;

import java.util.List;

import com.capg.mra.mobilerechargeapplication.dto.WalletHistory;

/**
 * @author Boola Rohan
 *
 */
public interface IWalletHistoryService {

	public WalletHistory addHistory(WalletHistory walletHistory);

	public List<WalletHistory> getWalletHistory(Long id);

}
