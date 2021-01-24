class Ping extends HTMLElement{

    get uri()
    {
        return this.getAttribute("uri");
    }
    connectedCallback()
    {
        fetch(this.uri).then(r => r.json()).then(j => this.innerText ="Prefix "+ j.message);
    }
}

customElements.define("a-post",Ping);