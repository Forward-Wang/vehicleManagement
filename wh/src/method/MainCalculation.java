package method;

import java.util.List;

import pojos.CompanyPrice;
import service.CompanyPriceService;
import service.ProvinceTypeService;

public class MainCalculation {
	private CompanyPriceService companypriceservice;
	private ProvinceTypeService provinceservice;
	private List<CompanyPrice> companyprice;
	
	public CompanyPriceService getCompanypriceservice() {
		return companypriceservice;
	}

	public void setCompanypriceservice(CompanyPriceService companypriceservice) {
		this.companypriceservice = companypriceservice;
	}

	public ProvinceTypeService getProvinceservice() {
		return provinceservice;
	}

	public void setProvinceservice(ProvinceTypeService provinceservice) {
		this.provinceservice = provinceservice;
	}

	//�˺������ڼ�����ѷ���
	public String maincalculation(String startplace, String destination, int weight)
	{
		System.out.println(startplace);
		System.out.println(destination);
		System.out.println(weight);
		String plan=null;
		int sum=9999;
		if(startplace.trim().equals(destination.trim()))
		{
			companyprice=companypriceservice.getCompanyPriceList();
			for (CompanyPrice company:companyprice)
			{
				int price=(weight-1)*company.getShengneixuzhong()+company.getShengneishouzhong();
				if(price<sum)
				{
					sum=price;
					plan="ʡ��������ʹ��"+company.getCompanyname()+"��˾������Ϊ�ѷ�������������Ϊ"+sum+"��";
					
				}
			}
			return plan;
		}
		else
		{
			if(provinceservice.getProvinceTypeByName(destination).getType().trim()=="1")
			{	
				int price;
				companyprice=companypriceservice.getCompanyPriceList();
				for (CompanyPrice company:companyprice)
				{
					price=((weight-1)*company.getZhuyaoshengxuzhong()+company.getZhuyaoshengshouzhong())*(1+company.getZhuyaoshengdiubaolv());
					if (price<sum)
					{
						sum=price;
						plan="ʡ��������ʹ��"+company.getCompanyname()+"��˾������Ϊ�ѷ�������������Ϊ"+sum+"��";
					}
				}
				return plan;
			}
			else
			{
				int price;
				companyprice=companypriceservice.getCompanyPriceList();
				for (CompanyPrice company:companyprice)
				{
					price=((weight-1)*company.getPianyuanshengxuzhong()+company.getPianyuanshengshouzhong())*(1+company.getPianyuanshengdiubaolv());
					if (price<sum)
					{
						sum=price;
						plan="ʡ��������ʹ��"+company.getCompanyname()+"��˾������Ϊ�ѷ�������������Ϊ"+sum+"��";
					}
				}
				return plan;
			}
		}
	}
}
