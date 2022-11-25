function copy() {
    let textarea = document.getElementById("textarea");
    textarea.disabled = false;
    textarea.select();
    document.execCommand("copy");
    textarea.disabled = true;
}
