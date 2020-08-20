package com.capg.mra.customermanagementsystem.service;

import java.util.List;

import com.capg.mra.customermanagementsystem.dto.WalletHistory;



/**
 * @author Boola Rohan
 *
 */
public interface IWalletHistoryService {

	public WalletHistory addHistory(WalletHistory walletHistory);

	public List<WalletHistory> getWalletHistory(Long id);

}
