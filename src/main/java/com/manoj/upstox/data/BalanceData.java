package com.manoj.upstox.data;

public class BalanceData {

        private Commodity commodity;

        private Equity equity;

        public Commodity getCommodity ()
        {
            return commodity;
        }

        public void setCommodity (Commodity commodity)
        {
            this.commodity = commodity;
        }

        public Equity getEquity ()
        {
            return equity;
        }

        public void setEquity (Equity equity)
        {
            this.equity = equity;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [commodity = "+commodity+", equity = "+equity+"]";
        }
}
