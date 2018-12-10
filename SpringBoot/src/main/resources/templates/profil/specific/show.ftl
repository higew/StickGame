<div>
	        <#if i.getName()??>
		        <div>Name : ${i.getName()}</div>
		        <#else>
		        <div>NULL</div>
	        </#if>
	        <#if i.getHp()??>
        <div>HP : ${i.getHp()}</div>
	        <#else>
	        <div>NULL</div>
	        </#if>
	        <#if i.getAtk()??>
	        <div>ATK : ${i.getAtk()}</div>
	        <#else>
	        <div>NULL</div>
        </#if>
        <#if i.getInkCost()??>
	        <div>InkCost ${i.getInkCost()}</div>
	        <#else>
	        <div>NULL</div>
        </#if>
    
        <div>
            <a href="/cards/edit/${i.getId()}">Edit</a>
            <a href="/cards/delete/${i.getId()}">Delete</a>
        </div>
        

    </div>