function copy() {
    let textarea = document.getElementById("textarea");
    textarea.disabled = false;
    textarea.select();
    document.execCommand("copy");
    textarea.disabled = true;
}
document.getElementById('switch').onchange = function(){
    if(this.checked){
        window.location='json2yaml.html';
    } else {
        window.location='yaml2json.html';
    }
};