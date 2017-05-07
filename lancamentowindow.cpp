#include "lancamentowindow.h"
#include "ui_lancamentowindow.h"
#include <QPixmap>

LancamentoWindow::LancamentoWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::LancamentoWindow)
{
    ui->setupUi(this);
    this->setStyleSheet("background-color: white;");
    this->setFixedSize(this->width(), this->height());
    QPixmap pix = QPixmap("logo.png");
    pix = pix.scaled(220, 220, Qt::KeepAspectRatio, Qt::SmoothTransformation);
    ui->logo->setPixmap(pix);
}

LancamentoWindow::~LancamentoWindow()
{
    delete ui;
}

void LancamentoWindow::on_btn_credito_clicked()
{
    ui->btn_credito->setStyleSheet("background-color: #D32F2F;\nfont: 14pt;Arial; bold;\ncolor: white;\nborder: none;");
    ui->btn_debito->setStyleSheet("background-color: #F44336;\nfont: 14pt;Arial; bold;\ncolor: white;\nborder: none;");
}

void LancamentoWindow::on_btn_debito_clicked()
{
    ui->btn_debito->setStyleSheet("background-color: #D32F2F;\nfont: 14pt;Arial; bold;\ncolor: white;\nborder: none;");
    ui->btn_credito->setStyleSheet("background-color: #F44336;\nfont: 14pt;Arial; bold;\ncolor: white;\nborder: none;");
}

void LancamentoWindow::on_btn_cancelar_clicked()
{
    close();
}

void LancamentoWindow::on_btn_salvar_clicked()
{
    close();
}
