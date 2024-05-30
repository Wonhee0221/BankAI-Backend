package com.hana.bankai.domain.account.dto;

import com.hana.bankai.domain.account.entity.Account;
import com.hana.bankai.domain.accounthistory.entity.AccountHistory;
import com.hana.bankai.domain.accounthistory.entity.HisType;
import com.hana.bankai.domain.product.entity.ProdType;
import lombok.*;

import java.time.LocalDateTime;

public class AccountResponseDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class GetBalance {
        private Long accBalance;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class SearchAcc {
        private String accCode;
        private String userName;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CheckRes {
        private Boolean check;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class getAccHis {
        private LocalDateTime hisDateTime;
        private HisType hisType;
        private String target;
        private Long hisAmount;
        private Long balance;

        public static getAccHis from(AccountHistory accHis, String target, Long hisAmount, Long balance) {
            return getAccHis.builder()
                    .hisDateTime(accHis.getHisDateTime())
                    .hisType(accHis.getHisType())
                    .target(target)
                    .hisAmount(hisAmount)
                    .balance(balance)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class getAccInfo {
        private String accCode;
        private Long accBalance;
        private String prodName;
        private ProdType prodType;

        public static getAccInfo from(Account acc) {
            return getAccInfo.builder()
                    .accCode(acc.getAccCode())
                    .accBalance(acc.getAccBalance())
                    .prodName(acc.getProduct().getProdName())
                    .prodType(acc.getProduct().getProdType())
                    .build();
        }
    }
}
