/*
*
*获取url参数
*
*/
function getParamFormURL(key) {
    var search = location.search,
        start, end;
    if (typeof key !== "string") {
        throw new Error("key必须是字符串型")
    }
    if (!key || !search || !new RegExp(key + "=", "g").test(search)) {
        return ""
    }
    key += "=";
    start = search.indexOf(key) + key.length;
    end = search.indexOf("&", start);
    end == -1 && (end = search.length);
    return search.substring(start, end)
}

/*
*
*获取url参数
*
*/
function getListValue(key,array,id,name) {
    var str='';
    for (var i = 0; i < array.length; i++) {
        if (array[i][id]==key)
        {
            str= array[i][name];
        }
    }
    return str;
}