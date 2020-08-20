package com.capg.mra.adminmanagementsystem.service;

import java.util.List;

import com.capg.mra.adminmanagementsystem.dto.WalletHistory;

public interface IWalletHistoryService {

	public WalletHistory addHistory(WalletHistory walletHistory);

	public List<WalletHistory> getWalletHistory(Long id);
}
