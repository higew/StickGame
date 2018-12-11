<div>
	        <#if i.getEffectIdentifier()??>
		        <div>Effect ID : ${i.getEffectIdentifier()}</div>
		        <#else>
		        <div>NULL</div>
	        </#if>
	        <#if i.getDescription()??>
        <div>Description : ${i.getDescription()}</div>
	        <#else>
	        <div>NULL</div>
	        </#if>

        <div>
            <a href="/effects/edit/${i.getId()}">Edit</a>
            <a href="/effects/delete/${i.getId()}">Delete</a>
        </div>


</div>
